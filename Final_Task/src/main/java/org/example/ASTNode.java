package org.example;

import java.util.List;

public interface ASTNode {
}

interface Statement extends ASTNode {}

interface Expression extends ASTNode {
   //  String prettyPrint();
  //   String toExpressionession();
}

record IDNode(String name) implements Expression, Type, ASTNode{}

// === Typen ===
interface Type extends ASTNode {}
record IntType() implements Type {}
record BoolType() implements Type {}
record CharType() implements Type {}
record StringType() implements Type {}
record VoidType() implements Type {}

// === Werte ===
record IntegerNode(int value) implements Expression, ASTNode{}
record StringNode(String value) implements Expression,  ASTNode{}
record BoolNode(boolean value) implements Expression, ASTNode{}
record CharNode(char value) implements Expression, ASTNode{}
record LitNode(char value)implements ASTNode{}
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
record FDeclNode(boolean virtual, Type type, IDNode id, ParamNodeDecl params, BlockNode block) implements ASTNode {}
record FCallNode(IDNode id, ParamNode params) implements ASTNode{}
record ParamNode(List<Expression> params)implements ASTNode{}

record ParamNodeDecl(List<Type> types,List<IDNode> ids)implements ASTNode{}

// === Class ===
record CDeclNode(IDNode name, List<FDeclNode> functions,BlockNode constructor) implements ASTNode{}

// === Method Call from class ===
record MCall(IDNode clars, IDNode fName, List<Expression> params) implements ASTNode{}

// ===Expression ===
//record CalcTypeNode(String value) implements ASTNode{}
/*enum CalcType{
        Mul,
        Div,
        Mod,
        Add,
        Sub,
        }*/
        
record ExprNode(String value, Expression left, Expression right) implements ASTNode, Expression{}
//ExprNode(+, ExprNode (null,5, ExprNode (-,4, 3))
//5+4-3