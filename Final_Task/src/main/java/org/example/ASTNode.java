package org.example;

import java.util.List;

public interface ASTNode {
}

interface Statement extends ASTNode {}

interface Expression extends ASTNode {
   //  String prettyPrint();
  //   String toExpressionession();
}

record IDNode(String name){}

// === Type Werte (int ...) ===

interface Type{}

record IntegerNode(Expression value) implements Expression, Type, ASTNode{}
record StringNode(Expression value) implements Expression, Type, ASTNode{}
record BoolNode(Expression value) implements Expression, Type, ASTNode{}
record CharNode(Expression value) implements Expression, Type, ASTNode{}

// === Variabel (Declaration, Initialisation...) ===
record DeclNode(Type type, IDNode name, boolean and) implements Statement, ASTNode{}
record InitNode(Type type, IDNode name, boolean and, Expression value) implements Statement, ASTNode{}
record AssiNode(Type type, Expression value) implements Statement, ASTNode{}

// === IF WHILE ... ===
record BlockNode(List<Statement> body) implements ASTNode{}

// prim1 comp1 prim2 comp2 prim3
//prim

record ComTypeNode(String value) implements ASTNode{}
record PrimExprNode(boolean negate, ExprNode expr) implements ASTNode{}
record ComNode(List<PrimExprNode> expr, List<ComTypeNode> comp) implements ASTNode{}
/*
enum CompType{
        DoubleEqual,
        NotEqual,
        LessThen,
        GreaterThen,
        LessOrEqual,
        GreaterOrEqual,
        And,
        Or
}*/

record IfNode(ComNode com, BlockNode thenBlock, BlockNode elseBlock )implements Statement, ASTNode{}
record WhileNode(ComNode com, BlockNode block) implements ASTNode{}

// === Function ===
record FDeclNode(boolean virtual, Type type, IDNode id, List<Expression> params, BlockNode block) implements ASTNode {}
record FCallNode(IDNode id, List<Expression> params) implements ASTNode{}

// === Class ===
record CDeclNode(IDNode name, List<FDeclNode> functions,BlockNode constructor) implements ASTNode{}

// === Method Call from class ===
record MCall(IDNode clars, IDNode fName, List<Expression> params) implements ASTNode{}

// ===Expression ===
record CalcTypeNode(String value)implements ASTNode{}
/*enum CalcType{
        Mul,
        Div,
        Mod,
        Add,
        Sub,
        }*/
        
record ExprNode(CalcTypeNode calc, ExprNode left, ExprNode right) implements ASTNode{}