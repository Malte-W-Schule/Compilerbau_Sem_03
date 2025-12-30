package org.example;

import java.util.List;

public interface ASTNode {
}

interface Statement extends ASTNode {}

interface Expression extends ASTNode {
   //  String prettyPrint();
  //   String toExpressionession();
}
interface Compare{}

record IDNode(String name){}

// === Type Werte (int ...) ===

interface Type{}

record IntegerNode(Expression value) implements Expression, Type{}
record StringNode(Expression value) implements Expression, Type{}
record BoolNode(Expression value) implements Expression, Type{}
record CharNode(Expression value) implements Expression, Type{}

// === Variabel (Declaration, Initialisation...) ===
record DeclNode(Type type, IDNode name, boolean and) implements Statement{}
record InitNode(Type type, IDNode name, boolean and, Expression value) implements Statement{}
record AssiNode(Type type, Expression value) implements Statement{}

// === IF WHILE ... ===
record BlockNode(List<Statement> body){}


record PrimExpression(boolean negate, Compare comp){} //todo iwas stimmt noch nich
record ComNode(List<PrimExpression> expr){}   //todo iwas mit comp und expr
record DoubleEqualsNode() implements Compare{}
record NotEqualNode() implements Compare{}
record LessThenNode() implements Compare{}
record GreaterThenNode() implements Compare{}
record LessOrEqualNode() implements Compare{}
record GreaterOrEqualNode() implements Compare{}
record AndNode() implements Compare{}
record OrNode() implements Compare{}

record IfNode(ComNode com, BlockNode thenBlock, BlockNode elseBlock )implements Statement{}
record WhileNode(ComNode com, BlockNode block){}

// === Function ===
record FDeclNode(boolean virtual, Type type, IDNode id, List<Expression> params, BlockNode block) {}
record FCallNode(IDNode id, List<Expression> params){}

// === Class ===
record CDeclNode(IDNode name, List<FDeclNode> functions){}

// === Method Call from class ===
record MCall(IDNode clars, IDNode fName, List<Expression> params){}

// ===Expression ===
enum CalcType{ //todo beten dass das so klappt
        Mul,
        Div,
        Mod,
        Add,
        Sub,
        }
        
record ExprNode(CalcType calc,ExprNode left, ExprNode right){}