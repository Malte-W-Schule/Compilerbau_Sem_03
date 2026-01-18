package org.example;

import java.util.ArrayList;
import java.util.List;

public class Interpreter {


    //visit
    public static void interpret(ProgramNode node, Environment env) {

        for (ASTNode n : node.statements()) {
            evaluateProgramNode(n, env);
        }
    }

    public static Object evaluateProgramNode(ASTNode node, Environment env) {
        if (node instanceof Statement) {
            return evaluateStatement((Statement) node, env);
        }
        if (node instanceof Expression) {
            return evaluateExpression((Expression) node, env);
        }
        throw new RuntimeException("Unbekannter Node Typ");
    }

    //todo return a value?
    private static Object evaluateStatement(Statement statementNode, Environment env) {
         return switch (statementNode) {
            // === Variable Declarations & Assignments ===
            case DeclNode decl -> {
                yield visitDeclNode(decl,env);
                // Deklaration: int x;
            }
            case InitNode init -> {
                yield visitInitNode(init, env);
                // Initialisierung: int x = 5;
            }
            case AssiNode assi -> {
                yield visitAssiNode(assi, env);
                // Zuweisung: x = 10;
            }

            // === Blocks (implementieren Block -> Statement) ===
            case BlockNode block -> {
                yield visitBlockNode(block, env);
                // Normaler Block: { ... }
            }
            case FBlockNode fBlock -> {
                yield visitFBlockNode( fBlock, env);
                // Funktions-Block (mit Return)
            }
            case CBlockNode cBlock -> {
                yield visitcBlockNode(cBlock, env);
                // Klassen-Block / Constructor-Block
            }

            // === Control Flow ===
            case IfNode ifNode -> {
                yield visitIfNode(ifNode, env);
                // If-Anweisung
            }
            case WhileNode whileNode -> {
                yield visitWhileNode(whileNode,env);
                // While-Schleife
            }
            case ReturnNode retNode -> {
                yield visitReturnNode(retNode, env);
                // Return Statement
            }

            // === Functions ===
            case FDeclNode fDecl -> {
                yield visitFDeclNode(fDecl, env);// Funktions-Deklaration
            }
            case FCallNode fCall -> {
                yield visitFCallNode(fCall, env);
                // Funktions-Aufruf (kann Statement sein: "doSomething();")
            }

            // === Classes & Objects ===
            case CDeclNode cDecl -> {
                yield visitCDeclNode(cDecl, env);
                // Klassen-Deklaration
            }
            case ConDeclNode conDecl -> {
                yield visitConDeclNode(conDecl, env);
                // Konstruktor-Deklaration
            }
            case ConCallNode conCall -> {
                yield visitConCallNode(conCall, env);
                // Konstruktor-Aufruf
            }
            case MCall mCall -> {
                yield visitMCallNode(mCall, env);
                // Methoden-Aufruf: obj.method();
            }
            default -> throw new IllegalStateException("Unexpected value: " + statementNode);
        };
    }

    //todo
    private static Object visitMCallNode(MCall mCall, Environment env) {
        return null;
    }

    private static Object visitConCallNode(ConCallNode conCall, Environment env) {
        return null;
    }

    private static Object visitConDeclNode(ConDeclNode conDecl, Environment env) {
        return null;
    }

    private static Object visitCDeclNode(CDeclNode cDecl, Environment env) {
        return null;
    }

    private static Object visitFCallNode(FCallNode fCall, Environment env) {
        return null;
    }

    private static Object visitWhileNode(WhileNode whileNode, Environment env) {
        return null;
    }

    private static Object visitReturnNode(ReturnNode retNode, Environment env) {
        return evaluateExpression(retNode.value(),env);
    }


    private static Object visitIfNode(IfNode ifNode, Environment env) {

        if(evaluateExpression(ifNode.com(), env).equals(true))
        {
            evaluateStatement(ifNode.thenBlock(), env);

        }
        else if(ifNode.elseBlock() != null){
            evaluateStatement(ifNode.elseBlock(), env);
        }
        return null;
    }

    //todo
    private static Object visitcBlockNode(CBlockNode cBlock, Environment env) {
        return null;
    }

    private static Object visitFBlockNode(FBlockNode fBlock, Environment env) {
        for (Statement s : fBlock.body()) {
            evaluateStatement(s, env);
        }
        return null;
    }

    private static Object visitBlockNode(BlockNode block, Environment env) {
        for (Statement s : block.body()) {
            evaluateStatement(s, env);
        }
        return null;
    }

    // return null?
    private static Object visitInitNode(InitNode init, Environment env) {
        env.define(init.id().name(), evaluateExpression(init.value(), env));
        return null;
    }

    // === Statements ===
    private static Object visitDeclNode(DeclNode declNode, Environment environment)
    {
        environment.define(declNode.id().name(), null);
        return null;
    }

    private static Object visitFDeclNode(FDeclNode fDeclNode, Environment env) {
        Fun fn = new Fun(fDeclNode, env);
        env.define(fDeclNode.id().name(), fn);
        return null;
    }

    private static Object visitAssiNode(AssiNode assiNode, Environment env)
    {
        env.assign(assiNode.id().name(), evaluateExpression(assiNode.value(), env));
        return null;
    }

    // === Expression ===
    private int visitIntegerNode(IntegerNode integerNode) {
        return integerNode.value();
    }

    private static Object evaluateExpression(Expression exprNode, Environment env) {
        return switch (exprNode) {
            case IntegerNode i -> i.value();
            case BoolNode b -> b.value();
            case StringNode str -> str.value();
            case CharNode c -> c.value();
            case IDNode id -> id.name(); // Hier holt er 'a' aus dem globalEnv

            case ArithmetischeExpressionNode math -> {
                Object left = evaluateExpression(math.left(), env);
                Object right = evaluateExpression(math.right(), env);
                yield evalMath(left, math.operator(), right); // Helper-Methode (siehe unten)
            }
            case LogischeExpressionNode logic -> {
                Object left = evaluateExpression(logic.left(), env);
                Object right = evaluateExpression(logic.right(), env);
                yield evalLogic(left, logic.operator(), right); // Helper-Methode (siehe unten)
            }
            case FCallNode fCall -> evalFuncCall(fCall, env);
            case MCall mCall -> evalMethodCall(mCall, env);
            case ConCallNode conCall -> evalConstructorCall(conCall, env);

            default -> throw new IllegalStateException("Unexpected expression: " + exprNode);
        };
    }

    private static Object evalFuncCall(FCallNode fCallNode, Environment env)
    {
        Fun fn = (Fun) env.get(fCallNode.id().name());

        List<Object> args = new ArrayList<>();
        for (int i = 0; i < fCallNode.params().params().size(); i++) {
            args.add(evaluateExpression(fCallNode.params().params().get(i), env));
        }

        env = new Environment(fn.closure());
        for (int i = 0; i < args.size(); i++) {
            env.define(fn.fDeclNode().params().params().get(i).id().name(), args.get(i));
        }
        evaluateStatement(fn.fDeclNode().block(), env);

        return null; //todo irgendetwas zurückgeben
    }

    private static Object evalMethodCall(MCall mCallNode, Environment env)
    {
        return null;
    }

    private static Object evalConstructorCall(ConCallNode conCallNode, Environment env)
    {
        return null;
    }


    // Helper für Arithmetik
    private static Object evalMath(Object left, String op, Object right) {
        if (left instanceof Integer l && right instanceof Integer r) {
            return switch (op) {
                case "+" -> l + r;
                case "-" -> l - r;
                case "*" -> l * r;
                case "/" -> l / r; // Achtung: Division durch 0 abfangen!
                case "%" -> l % r;
                default -> throw new RuntimeException("Unbekannter Operator: " + op);
            };
        }
        // Falls Strings addiert werden sollen:
        if (op.equals("+") && (left instanceof String || right instanceof String)) {
            return left.toString() + right.toString();
        }
        throw new RuntimeException("Typfehler in Arithmetik: " + left + " " + op + " " + right);
    }

    // Helper für Logik
    private static Object evalLogic(Object left, String op, Object right) {
        // Vergleiche (==, != gehen für alles)
        if (op.equals("==")) return left.equals(right);
        if (op.equals("!=")) return !left.equals(right);

        // Zahlenvergleiche
        if (left instanceof Integer l && right instanceof Integer r) {
            return switch (op) {
                case "<" -> l < r;
                case "<=" -> l <= r;
                case ">" -> l > r;
                case ">=" -> l >= r;
                default -> throw new RuntimeException("Unbekannter Operator: " + op);
            };
        }

        throw new RuntimeException("Vergleich nicht möglich zwischen: " + left + " und " + right);
    }
}
