package org.example;

import java.util.ArrayList;
import java.util.List;

public class Interpreter {

    private static void setup(Environment env)
    {

        // --- print_int(int) ---
        FDeclNode fakePrintIntDecl = createFakeFDecl("print_int", new IntType());
        env.define("print_int_" + new IntType().toString(), new NativePrint(fakePrintIntDecl, null));

        // --- print_string(string) ---
        FDeclNode fakePrintStringDecl = createFakeFDecl("print_str", new StringType());
        env.define("print_str_" + new StringType().toString(), new NativePrint(fakePrintStringDecl, null));

        // --- print_char(char) ---
        FDeclNode fakePrintCharDecl = createFakeFDecl("print_char", new CharType());
        env.define("print_char_" + new CharType().toString(), new NativePrint(fakePrintCharDecl, null));

        // --- print_bool(bool) ---
        FDeclNode fakePrintBoolDecl = createFakeFDecl("print_bool", new BoolType());
        env.define("print_bool_" + new BoolType().toString(), new NativePrint(fakePrintBoolDecl, null));

    }

    private static FDeclNode createFakeFDecl(String name, Type paramType) {
        IDNode funcId = new IDNode(name);
        SingleParamNode param = new SingleParamNode(paramType, false, new IDNode("value"));
        ParamNodeDecl params = new ParamNodeDecl(List.of(param));
        FBlockNode emptyBlock = new FBlockNode(null, List.of());
        return new FDeclNode(false, new VoidType(), false, funcId, params, emptyBlock, name);
    }

    //visit
    public static void interpret(ProgramNode node, Environment env) {
        setup(env);
        for (ASTNode n : node.statements()) {
           // System.out.println(n+":");
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
                yield evalDeclNode(decl, env);
                // Deklaration: int x;
            }
            case InitNode init -> {
                yield evalInitNode(init, env);
                // Initialisierung: int x = 5;
            }
            case AssiNode assi -> {
                yield evalAssiNode(assi, env);
                // Zuweisung: x = 10;
            }
            case FCallNode func ->{
                yield evalFuncCall(func, env);
            }

            // === Blocks (implementieren Block -> Statement) ===
            case BlockNode block -> {
                yield evalBlockNode(block, env);
                // Normaler Block: { ... }
            }
            case FBlockNode fBlock -> {
                yield evalFBlockNode(fBlock, env);
                // Funktions-Block (mit Return)
            }
            case CBlockNode cBlock -> {
                yield evalcBlockNode(cBlock, env);
                // Klassen-Block / Constructor-Block
            }

            // === Control Flow ===
            case IfNode ifNode -> {
                yield evalIfNode(ifNode, env);
                // If-Anweisung
            }
            case WhileNode whileNode -> {
                yield evalWhileNode(whileNode, env);
                // While-Schleife
            }
            case ReturnNode retNode -> {
                yield evalReturnNode(retNode, env);
                // Return Statement
            }

            // === Functions ===
            case FDeclNode fDecl -> {
                yield evalFDeclNode(fDecl, env);// Funktions-Deklaration
            }

            // === Classes & Objects ===
            case CDeclNode cDecl -> {
                yield evalCDeclNode(cDecl, env);
                // Klassen-Deklaration
            }
            case ConDeclNode conDecl -> {
                yield evalConDeclNode(conDecl, env);
                // Konstruktor-Deklaration
            }
            case ConCallNode conCall -> {
                yield evalConCallNode(conCall, env);
                // Konstruktor-Aufruf
            }
            case MCall mCall -> {
                yield evalMCallNode(mCall, env);
                // Methoden-Aufruf: obj.method();
            }
            default -> throw new IllegalStateException("Unexpected value: " + statementNode);
        };
    }

    //todo
    private static Object evalMCallNode(MCall mCall, Environment env) {
        return null;
    }

    private static Object evalConCallNode(ConCallNode conCall, Environment env) {
        return null;
    }

    private static Object evalConDeclNode(ConDeclNode conDecl, Environment env) {
        return null;
    }

    private static Object evalCDeclNode(CDeclNode cDecl, Environment env) {
        return null;
    }
    
    private static Object evalWhileNode(WhileNode whileNode, Environment env) {
        while(evaluateExpression(whileNode.com(), env).equals(true))
        {
            evaluateStatement(whileNode.block(), env);
        }
        return null;
    }

    private static Object evalReturnNode(ReturnNode retNode, Environment env) {
        return evaluateExpression(retNode.value(), env);
    }

    // fertig

    private static Object evalIfNode(IfNode ifNode, Environment env) {

        if (evaluateExpression(ifNode.com(), env).equals(true)) {
            evaluateStatement(ifNode.thenBlock(), env);

        } else if (ifNode.elseBlock() != null) {
            evaluateStatement(ifNode.elseBlock(), env);
        }
        return null;
    }

    private static Object evalcBlockNode(CBlockNode cBlock, Environment env) {
        for (Statement s : cBlock.body()) {
            evaluateStatement(s, env);
        }
        return null;
    }

    private static Object evalFBlockNode(FBlockNode fBlock, Environment env) {
        //System.out.println("--Fblock");
        for (Statement s : fBlock.body()) {
            evaluateStatement(s, env);
        }
        if (fBlock.ret() != null) {
            evaluateExpression(fBlock.ret().value(), env);
        }
        return null;
    }

    private static Object evalBlockNode(BlockNode block, Environment env) {
        for (Statement s : block.body()) {
            evaluateStatement(s, env);
        }
        return null;
    }

    // return null?
    private static Object evalInitNode(InitNode init, Environment env) {
        env.define(init.id().name(), evaluateExpression(init.value(), env));
        return null;
    }

    // === Statements ===
    private static Object evalDeclNode(DeclNode declNode, Environment environment) {
        environment.define(declNode.id().name(), null);
        return null;
    }

    private static Object evalFDeclNode(FDeclNode fDeclNode, Environment env) {

        //hole den Namen der Funktion
        String name = fDeclNode.id().name();
        //hole Parameter aus fDecl und löse sie zu einer Typen Liste auf
        ArrayList<Type> paramTypen = new ArrayList<>();

        for (int i = 0; i < fDeclNode.params().params().size(); i++) {
            paramTypen.add(fDeclNode.params().params().get(i).type());
        }

        //gehe die Parameter Liste durch. Hänge ja nach typ eine Bezeichnung an den Namen der Funktion->mache so Kombi aus Funktion und Params einzigartig
        if(paramTypen.size()!=0) {
            for (int i = 0; i < paramTypen.size(); i++) {
                name = name + "_" + paramTypen.get(i).toString();
            }
        }

        Fun fn = new Fun(fDeclNode, env);
        env.define(name, fn);
        return null;
    }


    private static Object evalAssiNode(AssiNode assiNode, Environment env) {
        env.assign(assiNode.id().name(), evaluateExpression(assiNode.value(), env));
        return null;
    }

    // === Expression ===

    private static Object evaluateExpression(Expression exprNode, Environment env) {
        return switch (exprNode) {
            case IntegerNode i -> i.value();
            case BoolNode b -> b.value();
            case StringNode str -> str.value();
            case CharNode c -> c.value();
            case IDNode id -> env.get(id.name()); // Hier holt er 'a' aus dem globalEnv

            case ArithmetischeExpressionNode math -> {
                Object left = evaluateExpression(math.left(), env);
                Object right = evaluateExpression(math.right(), env);
             //   System.out.println(" Ergebnis: "+evalMath(left,math.operator(),right)); //todo entfernen
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

    private static Object evalFuncCall(FCallNode fCallNode, Environment env) {

        String funktionsNameMitParamtern = fCallNode.id().name();

        fCallNode.params();
        for(Expression exp : fCallNode.params().params())
        {
            Type t =  resolve(exp);
            funktionsNameMitParamtern = funktionsNameMitParamtern + "_" + t.toString();
        }

        Fun fn = (Fun) env.get(funktionsNameMitParamtern);

        List<Object> args = new ArrayList<>();
        for (int i = 0; i < fCallNode.params().params().size(); i++) {
            args.add(evaluateExpression(fCallNode.params().params().get(i), env));
        }

        env = new Environment(fn.getClosure());
        fn.call(env, args);

        return evaluateStatement(fn.getfdeclNode().block(), env); //todo irgendetwas zurückgeben
    }


    // Expressions MÜSSEN einen PrimType zurückgeben
    static public Type resolve(Expression expression) {

        return switch (expression) {
            case IntegerNode i -> new IntType();
            case StringNode s -> new StringType();
            case BoolNode b -> new BoolType();
            case CharNode c -> new CharType();
        /*    case MCall m -> visitMCall(m); todo implementieren
            case FCallNode f -> visitFCall(f);
            case LogischeExpressionNode e -> visitLogischeExpressionNode(e);
            case ArithmetischeExpressionNode e -> visitArithmetischeExpressionNode(e);
            case IDNode id -> visitID(id);*/
            default -> throw new IllegalStateException("Unexpected value: " + expression);
        };
    }

    //todo m call für klassen instanzen.
    private static Object evalMethodCall(MCall mCallNode, Environment env) {

        //klasse
        //von der klasse die funktion
        //mit parametern aufrufen
        Object obj = env.get(mCallNode.clars().name());


        return null;
    }

    private static Object evalConstructorCall(ConCallNode conCallNode, Environment env) {
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
