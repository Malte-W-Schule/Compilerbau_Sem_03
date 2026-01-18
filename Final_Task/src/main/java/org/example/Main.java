package org.example;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import org.example.antlr.CplusplusLexer;
import org.example.antlr.CplusplusParser;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        Path testsdir = Paths.get("src/test/pos/");


        // Der Rest bleibt identisch...
        if (!Files.exists(testsdir) || !Files.isDirectory(testsdir)) {
            System.err.println("Verzeichnis nicht gefunden: " + testsdir.toAbsolutePath());
            System.err.println("Bitte stelle sicher, dass der Ordner 'tests' im Projektverzeichnis liegt.");
            return;
        }
        int i = 1;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(testsdir)) {

            Path entry = Path.of("src/test/postemp/test6_construcors.txt");
            try {
                String fileContent = Files.readString(entry);
                run(fileContent,i);
                i++;
            } catch (Exception e) {
                System.err.println("Fehler: " + e.getMessage());
                throw e;
            }
///*
          /* for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    System.out.println("\n--------------------------------------------------");
                    System.out.println("Verarbeite Datei: " + entry.getFileName());

                    try {
                        String fileContent = Files.readString(entry);
                        run(fileContent,i);
                        i++;
                    } catch (Exception e) {
                        System.err.println("Fehler: " + e.getMessage());
                    }
                }
            }//*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run(String inputString,int testIndex){

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

        System.out.println("Resolver:");
        Resolver solver = new Resolver(binder);
        solver.resolve((ProgramNode) meinEigenerAST);

        //System.out.println(tree.toStringTree(meinEigenerAST));
        //System.out.println(meinEigenerAST);
        System.out.println("=============== Test End: " + testIndex + " ===============");

    }

}