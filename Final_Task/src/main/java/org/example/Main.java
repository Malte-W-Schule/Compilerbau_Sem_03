package org.example;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import org.example.antlr.CplusplusLexer;
import org.example.antlr.CplusplusParser;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner; // WICHTIG: Scanner importieren

public class Main {
    public static boolean istSchon = false;
    public static Binder binder = new Binder();

    public static void main(String[] args) {

        testBinderResolver();

        if (args.length > 0 && args[0].equals("--repl")) {
            startRepl(null);
        } else {
            runFileTests();
        }
    }

    // === NEUE REPL METHODE ===
    public static void startRepl(Environment env) {
        System.out.println("---------------------------");

        Scanner scanner = new Scanner(System.in);

        Environment globalEnv = env;

        while (true) {
            System.out.print(">> "); // Prompt
            if (!scanner.hasNextLine()) break;

            String line = scanner.nextLine();

            // Abbruchbedingung
            if (line.trim().equalsIgnoreCase("exit")) {
                break;
            }

            // Leere Zeilen überspringen
            if (line.trim().isEmpty()) continue;

            try {
                // aufruf von angepasster run mehtode mit env
                runSnippet(line, globalEnv);
            } catch (Exception e) {
                System.err.println("Fehler: " + e.getMessage());
                throw e;
            }

        }
        System.out.println("REPL beendet.");
    }

    // === Refactoring deiner run-Logik ===
    public static Environment runSnippet(String inputString, Environment env) {
        CharStream input = CharStreams.fromString(inputString);
        CplusplusLexer lexer = new CplusplusLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CplusplusParser parser = new CplusplusParser(tokens);

        ParseTree tree = parser.program();

        ASTGenerator generator = new ASTGenerator();
        ASTNode ast = generator.visit(tree);
        if(binder == null)
        {
            binder = new Binder();
            binder.visitProgram((ProgramNode) ast);
        }

       // Binder binder = new Binder();
        binder.visitProgram((ProgramNode) ast);

        Resolver solver = new Resolver(binder);
        solver.resolve((ProgramNode) ast);

        Interpreter interpreter = new Interpreter();

        interpreter.interpret((ProgramNode) ast, env,istSchon);
        istSchon = true;
        return env;
    }

    public static Environment run(String inputString, int testIndex) {
        // Für Tests immer ein frisches Environment
        Environment env = runSnippet(inputString, new Environment(null));
        return env;
    }

    public static void runFileTests() {

        System.out.println("=============== Test Start: ===============");
        Path testsdir = Paths.get("src/test/pos/");
        if (!Files.exists(testsdir) || !Files.isDirectory(testsdir)) {
            System.err.println("Verzeichnis nicht gefunden: " + testsdir.toAbsolutePath());
            return;
        }

        int i = 1;
        try {
            Path entry = Path.of("src/test/pos/test0.txt");
            if (Files.exists(entry)) {
                String fileContent = Files.readString(entry);
                Environment env = run(fileContent, i);

                System.out.println("starte REPL...");
                startRepl(env);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=============== Test End: ===============");
    }



    public static void testBinderResolver(){
        Path testsdir = Paths.get("src/test/pos");

        // Der Rest bleibt identisch...
        if (!Files.exists(testsdir) || !Files.isDirectory(testsdir)) {
            System.err.println("Verzeichnis nicht gefunden: " + testsdir.toAbsolutePath());
            System.err.println("Bitte stelle sicher, dass der Ordner 'tests' im Projektverzeichnis liegt.");
            return;
        }
        int i = 1;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(testsdir)) {

            Path entry = Path.of("src/test/pos/test7_constr_inheritance.txt");
            try {
                String fileContent = Files.readString(entry);
                runEinzelneTests(fileContent,i);
                i++;
            } catch (Exception e) {
                System.err.println("Fehler: " + e.getMessage());
                throw e;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runEinzelneTests(String inputString,int testIndex){

        System.out.println("=============== Test Start: " + testIndex + " ===============");


        CharStream input = CharStreams.fromString(inputString);
        //CharStream input = CharStreams.fromString("int x = 5;");

        CplusplusLexer lexer = new CplusplusLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CplusplusParser parser = new CplusplusParser(tokens);
        ParseTree tree = parser.program();
        System.out.println("Parse-Tree: ");
        System.out.println(tree.toStringTree(parser));

        System.out.println("AST:");
        ASTGenerator generator = new ASTGenerator();
        ASTNode meinEigenerAST = generator.visit(tree);
        //ASTGenerator.print(meinEigenerAST);

        System.out.println("Binder:");
        Binder binder = new Binder();
        binder.visitProgram((ProgramNode) meinEigenerAST);

        System.out.println();
        System.out.println("Resolver:");
        Resolver solver = new Resolver(binder);
        solver.resolve((ProgramNode) meinEigenerAST);

        //System.out.println(tree.toStringTree(meinEigenerAST));
        //System.out.println(meinEigenerAST);
        System.out.println("=============== Test End: " + testIndex + " ===============");

    }

}

