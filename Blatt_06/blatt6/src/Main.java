// Main.java - Test und Beispielprogramme
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Beispielprogramme zum Testen
        String[] testPrograms = {
                // Einfache Literale
                "42",
                "\"hello world\"",
                "true",

                // Einfache Arithmetik
                "(+ 1 2)",
                "(* 3 4)",
                "(+ 1 2 3 4)",

                // Verschachtelte Ausdrücke
                "(+ (* 2 3) (/ 10 2))",

                // Vergleiche
                "(< 1 2)",
                "(= 5 5)",

                // Variable Definition
                "(def x 42)",

                // Funktion mit print
                "(print \"hello world\")",
                "(print (str \"wuppie\" \"fluppie\"))",

                // If-Else
                "(if (< 1 2) (print \"true\") (print \"false\"))",

                // Funktion definieren
                "(defn hello (n) (str \"hello \" n))",

                // Let-Binding
                "(let (x 1 y 2) (+ x y))",

                // Rekursive Fakultätsfunktion
                "(defn fac (n) (if (< n 2) 1 (* n (fac (- n 1)))))",

                // Listen
                "(list 1 2 3)",
                "(head (list 1 2 3))",
                "(tail (list 1 2 3))",
                "(nth (list \"abc\" false 99) 2)",

                // Komplexes Programm mit mehreren Ausdrücken
                "(def x 10)\n(def y 20)\n(+ x y)",

                // Do-Block
                "(do (print \"first\") (print \"second\") (print \"third\"))"
        };

        System.out.println("=".repeat(70));
        System.out.println("Lisp-Parser Test Suite");
        System.out.println("=".repeat(70));
        System.out.println();

        for (int i = 0; i < testPrograms.length; i++) {
            String program = testPrograms[i];
            System.out.println("Test " + (i + 1) + ":");
            System.out.println("-".repeat(70));
            System.out.println("Input:");
            System.out.println(program);
            System.out.println();

            try {
                // Lexing
                Lexer lexer = new Lexer(program);
                List<Token> tokens = lexer.tokenize();

                System.out.println("Tokens:");
                for (Token token : tokens) {
                    if (token.getType() != Token.TokenType.EOF) {
                        System.out.println("  " + token);
                    }
                }
                System.out.println();

                // Parsing
                Parser parser = new Parser(tokens);
                ProgramNode ast = parser.parse();

                System.out.println("AST (Pretty Print):");
                System.out.println(ast.prettyPrint(0));
                System.out.println();

                System.out.println("S-Expression (reconstructed):");
                System.out.println(ast.toSExpression());
                System.out.println();

            } catch (Lexer.LexerException e) {
                System.err.println("Lexer Error: " + e.getMessage());
                System.out.println();
            } catch (Parser.ParserException e) {
                System.err.println("Parser Error: " + e.getMessage());
                System.out.println();
            }

            System.out.println("=".repeat(70));
            System.out.println();
        }

        // Test für Fehlerbehandlung
        System.out.println("\nFehlerbehandlung Tests:");
        System.out.println("=".repeat(70));

        String[] errorPrograms = {
                "(+ 1 2",           // Fehlende schließende Klammer
                "\"unterminated",   // Nicht geschlossener String
                "(def)",            // Fehlende Argumente
                "(if true)",        // Fehlende then-Branch
                "@invalid"          // Ungültiges Zeichen
        };

        for (int i = 0; i < errorPrograms.length; i++) {
            String program = errorPrograms[i];
            System.out.println("\nError Test " + (i + 1) + ": " + program);
            try {
                Lexer lexer = new Lexer(program);
                List<Token> tokens = lexer.tokenize();
                Parser parser = new Parser(tokens);
                parser.parse();
                System.out.println("ERROR: Should have thrown an exception!");
            } catch (Lexer.LexerException e) {
                System.out.println("✓ Lexer caught error: " + e.getMessage());
            } catch (Parser.ParserException e) {
                System.out.println("✓ Parser caught error: " + e.getMessage());
            }
        }

        System.out.println("\n" + "=".repeat(70));

        // Beispiel: Datei einlesen (wenn vorhanden)
        if (args.length > 0) {
            String filename = args[0];
            System.out.println("\n\nReading from file: " + filename);
            System.out.println("=".repeat(70));

            try {
                String content = new String(Files.readAllBytes(Paths.get(filename)));
                Lexer lexer = new Lexer(content);
                List<Token> tokens = lexer.tokenize();
                Parser parser = new Parser(tokens);
                ProgramNode ast = parser.parse();

                System.out.println("AST:");
                System.out.println(ast.prettyPrint(0));
                System.out.println();
                System.out.println("S-Expression:");
                System.out.println(ast.toSExpression());

            } catch (IOException e) {
                System.err.println("Could not read file: " + e.getMessage());
            } catch (Lexer.LexerException e) {
                System.err.println("Lexer Error: " + e.getMessage());
            } catch (Parser.ParserException e) {
                System.err.println("Parser Error: " + e.getMessage());
            }
        }
    }
}