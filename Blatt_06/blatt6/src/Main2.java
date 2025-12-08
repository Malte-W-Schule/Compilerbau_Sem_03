import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Environment globalEnv = new Environment(null);
        Interpreter.setup(globalEnv);

        String s2 = "(def a 100) (let ((x 10) (y 20)) (print (+ x y a)))";

        System.out.println("--- Skript Start ---");
        run(s2, globalEnv); // Hilfsmethode nutzen

        System.out.println("--- REPL Start (Tippe Code) ---");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("exit")) break;
            if (input.trim().isEmpty()) continue;

            try {
                // Wir nutzen immer wieder dasselbe globalEnv!
                run(input, globalEnv);
            } catch (Exception e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }
    }

    private static void run(String source, Environment env) {
        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.tokenize();

        Parser parser = new Parser(tokens);
        ProgramNode programNode = parser.parse();

        // Interpreter ist jetzt statisch!
        Interpreter.interpret(programNode, env);
    }
}