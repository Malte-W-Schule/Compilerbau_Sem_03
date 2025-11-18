//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String s = "(+ 1 (* 2 \n 3))";
        ASTParser p = new ASTParser(s);

        System.out.println(p.parse());
    }
}