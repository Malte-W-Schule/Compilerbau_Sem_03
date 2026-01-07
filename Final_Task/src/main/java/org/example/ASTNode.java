package org.example;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.List;

public interface ASTNode {

    default void A()
    {
        System.out.println(this);
    }
}

interface Statement extends ASTNode {}

interface Expression extends ASTNode {
   //  String prettyPrint();
  //   String toExpressionession();
}

record IDNode(String name) implements Expression, Type, ASTNode{}

// === Typen ===
interface Type extends ASTNode {}
record ProgramNode(List<Statement> statements) implements ASTNode{}
record IntType() implements Type {}
record BoolType() implements Type {}
record CharType() implements Type {}
record StringType() implements Type {}
record VoidType() implements Type {}

// === Werte ===
record IntegerNode(String plusMinusSign, int value) implements Expression, ASTNode{}
record StringNode(String value) implements Expression,  ASTNode{}
record BoolNode(boolean value) implements Expression, ASTNode{}
record CharNode(char value) implements Expression, ASTNode{}
record LitNode(char value)implements ASTNode{}
// === Variabel (Declaration, Initialisation...) ===
record DeclNode(Type type, IDNode id, boolean and) implements Statement, ASTNode{}
record InitNode(Type type, IDNode id, boolean and, Expression value) implements Statement, ASTNode{}
record AssiNode(IDNode id, Expression value) implements Statement, ASTNode{}

// === IF WHILE ... ===
record BlockNode(List<Statement> body) implements ASTNode,Statement{}

// prim1 comp1 prim2 comp2 prim3
//prim

//record ComTypeNode(String value) implements ASTNode{}
record PrimExprNode(boolean negate, Expression expr) implements ASTNode{}
//record ComNode(List<PrimExprNode> primExprs , List<String> values) implements ASTNode, Expression{}

//record NestedComNode(PrimExprNode primNode, ComTypeNode comNode) implements ASTNode{}

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

record IfNode(Expression com, BlockNode thenBlock, BlockNode elseBlock )implements Statement, ASTNode{}
record WhileNode(Expression com, BlockNode block) implements ASTNode,Statement{}

// === Function ===
record FDeclNode(boolean virtual, Type type, boolean and, IDNode id, ParamNodeDecl params, BlockNode block) implements ASTNode,Statement {}
record FCallNode(IDNode id, ParamNode params) implements ASTNode,Statement{}
record ParamNode(List<Expression> params)implements ASTNode{}

record ParamNodeDecl(List<SingleParamNode> params)implements ASTNode{}
record SingleParamNode(Type t, boolean and, IDNode id) implements ASTNode {}
// === Class ===
record CDeclNode(IDNode name, List<FDeclNode> functions,ConDeclNode constructor) implements ASTNode,Statement{}
// constructor
record ConDeclNode(IDNode name,BlockNode block) implements ASTNode,Statement{};
record ConCallNode(IDNode name) implements ASTNode,Statement{}

// === Method Call from class ===
record MCall(IDNode clars, IDNode fName, List<Expression> params) implements ASTNode,Statement{}

// ===Expression ===
//record CalcTypeNode(String value) implements ASTNode{}
/*enum CalcType{
        Mul,
        Div,
        Mod,
        Add,
        Sub,
        }*/
        
record ExprNode(String operator, Expression left, Expression right) implements ASTNode, Expression{}
//ExprNode(+, ExprNode (null,5, ExprNode (-,4, 3))
//5+4-3
record ReturnNode(Expression value) implements ASTNode {}