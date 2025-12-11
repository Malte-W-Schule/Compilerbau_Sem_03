import java.util.ArrayList;
import java.util.List;

public class Interpreter {

    public static void interpret(ProgramNode node, Environment env) {

        for(ASTNode n : node.getNodes()) {
            evaluate(n, env);
        }
    }

    public static void setup(Environment env)
    {
        env.define("+", new LispFunction() {

            @Override
            public Object apply(List<Object> args) {

                double sum = 0;

                for (Object arg : args) {

                    if (!(arg instanceof Number)) {

                        throw new RuntimeException("Semantischer Fehler: '+' erwartet Zahlen, bekam: " + arg);

                    }

                    sum += ((Number) arg).doubleValue();

                }

                return sum;

            }

        });



        env.define("-", new LispFunction() {

            @Override

            public Object apply(List<Object> args) {

                double sum = 0;



                for (Object arg : args) {

                    if (!(arg instanceof Number)) {

                        throw new RuntimeException("Semantischer Fehler: '+' erwartet Zahlen, bekam: " + arg);

                    }

                    sum -= ((Number) arg).doubleValue();

                }

                return sum;

            }

        });



        env.define("*", new LispFunction() {

            @Override

            public Object apply(List<Object> args) {

                double sum = 0;



                for (Object arg : args) {

                    if (!(arg instanceof Number)) {

                        throw new RuntimeException("Semantischer Fehler: '+' erwartet Zahlen, bekam: " + arg);

                    }

                    sum *= ((Number) arg).doubleValue();

                }

                return sum;

            }

        });

        env.define("/", new LispFunction() {

            @Override

            public Object apply(List<Object> args) {

                double sum = 0;



                for (Object arg : args) {

                    if (!(arg instanceof Number)) {

                        throw new RuntimeException("Semantischer Fehler: '+' erwartet Zahlen, bekam: " + arg);

                    }

                    sum /= ((Number) arg).doubleValue();

                }

                return sum;

            }

        });
        
    }

    public static Object evaluate(ASTNode node, Environment env) {
        if (node instanceof Statement) {
            return execute((Statement) node, env);
        }
        if (node instanceof Expression) {
            return evaluateExpression((Expression) node, env);
        }
        throw new RuntimeException("Unbekannter Node Typ");
    }

    private static Object execute(Statement statementNode, Environment env) {
        return switch (statementNode) {
            case DefNode def -> {
                Object value = evaluate(def.getValue(), env);
                env.define(def.getName(), value);
                yield value;
            }
            case DefnNode defn -> {
                LispFunction func = new UserDefinedFunction(defn, env);
                env.define(defn.getName(), func);
                yield func;
            }
            default -> throw new IllegalStateException("Unexpected statement: " + statementNode);
        };
    }

    private static Object evaluateExpression(Expression exprNode, Environment env) {
        return switch (exprNode) {
            case IntegerNode i -> i.getValue();
            case BooleanNode b -> b.getValue();
            case StringNode str -> str.getValue();
            case VariableNode var -> env.get(var.getName()); // Hier holt er 'a' aus dem globalEnv

            case DoNode doNode -> {
                Object result = null;
                for(ASTNode n : doNode.getNodes()) result = evaluate(n, env);
                yield result;
            }

            case LetNode let -> {
                Environment localEnv = new Environment(env); // Scope erstellen
                for(int i = 0; i < let.getValues().size(); i++) {
                    String name = let.getNames().get(i);
                    Object val = evaluate(let.getValues().get(i), env);
                    localEnv.define(name, val);
                }
                yield evaluate(let.getBody(), localEnv);
            }

            case ListNode call -> {
                Object operator = evaluate(call.getOperator(), env);
                List<Object> args = new ArrayList<>();
                for (Expression argExpr : call.getArguments()) {
                    args.add(evaluate(argExpr, env));
                }
                if (operator instanceof LispFunction func) {
                    yield func.apply(args);
                }
                throw new RuntimeException("Erwartete Funktion, bekam: " + operator);
            }
            default -> throw new IllegalStateException("Unexpected expression: " + exprNode);
        };
    }
}