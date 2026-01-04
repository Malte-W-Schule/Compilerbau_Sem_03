package org.example;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.CplusplusLexer;
import org.antlr.v4.runtime.*;
import org.example.antlr.CplusplusParser;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        String complexCode =
                "class Animal {" +
                        "  public:" +
                        "    virtual void makeSound() {" +
                        "        int volume = 10;" +
                        "    }" +
                        "};" +
                        "" +
                        "class Dog : public Animal {" +
                        "  public:" +
                        "    void bark(int times) {" +
                        "        int i = 0;" +
                        "        while(i < times && !(i == 10)) {" +
                        "            i = i + 1;" +
                        "        }" +
                        "    }" +
                        "};" +
                        "" +
                        "int main() {" +
                        "    int& ref = x;" +
                        "    Dog d;" +
                        "    d.bark(5);" +
                        "    return 0;" +
                        "}";

        CharStream input = CharStreams.fromString(complexCode);
        //CharStream input = CharStreams.fromString("int x = 5;");

        CplusplusLexer lexer = new CplusplusLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CplusplusParser parser = new CplusplusParser(tokens);
        ParseTree tree = parser.program();

        System.out.println(tree.toStringTree(parser));

        ASTGenerator generator = new ASTGenerator();
        ASTNode meinEigenerAST = generator.visit(tree);
    }
}