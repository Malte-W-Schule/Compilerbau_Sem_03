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

interface Block extends ASTNode,Statement{}

record IDNode(String name) implements Expression, Type, ASTNode{}

// === Typen ===
interface Type extends ASTNode {}
record ProgramNode(List<Statement> statements) implements ASTNode{}
record IntType() implements Type {}
record BoolType() implements Type {}
record CharType() implements Type {}
record StringType() implements Type {}
record VoidType() implements Type {}
record IDType(IDNode id) implements Type {}

// === Werte ===
record IntegerNode(String plusMinusSign, int value) implements Expression, ASTNode{}
record StringNode(String value) implements Expression,  ASTNode{}
record BoolNode(boolean value) implements Expression, ASTNode{}
record CharNode(char value) implements Expression, ASTNode{}
record LitNode(char value)implements ASTNode{}
// === Variabel (Declaration, Initialisation...) ===
record DeclNode(Type type, IDNode id, boolean and) implements Statement, ASTNode{}
record InitNode(Type type, IDNode id, boolean and, Expression value) implements Statement, ASTNode{}
record AssiNode(IDNode objectId,IDNode id, Expression value) implements Statement, ASTNode{}

// === Blöcke ===
record BlockNode(List<Statement> body) implements Block{}
record FBlockNode(List<Statement> body) implements Block{}
record CBlockNode(List<Statement> body) implements Block{}

// === IF WHILE ... ===
record IfNode(Expression com, Block thenBlock, Block elseBlock )implements Statement, ASTNode{}
record WhileNode(Expression com, Block block) implements ASTNode,Statement{}

// === Function ===
record FDeclNode(boolean virtual, Type type, boolean and, IDNode id, ParamNodeDecl params, Block block) implements ASTNode,Statement {}
record FCallNode(IDNode id, ParamCallNode params) implements ASTNode, Statement, Expression{}
// === Parameter ===
record ParamNode(ParamCallNode params)implements ASTNode{}
record ParamCallNode(List<Expression> params)implements ASTNode{}
record ParamNodeDecl(List<SingleParamNode> params)implements ASTNode{}
record SingleParamNode(Type type, boolean and, IDNode id) implements ASTNode {}

// === Class ===
record CDeclNode(IDNode name, Block block ) implements ASTNode,Statement{}
// constructor
//List<FDeclNode> functions,ConDeclNode constructor
// Point(int a, int b) { x = a; y = b; }
record ConDeclNode(IDNode name, ParamNodeDecl params, Block block) implements ASTNode,Statement{};
//Default: Point p; Parametrisiert: Point p = Point(3, 4);
record ConCallNode(IDType type, IDNode name, ParamCallNode params) implements ASTNode,Statement, Expression{}

// === Method Call from class ===
record MCall(IDNode clars, IDNode fName,ParamCallNode params) implements ASTNode, Statement, Expression{}

// ===Expression ===
record ArithmetischeExpressionNode(Expression left,String operator,Expression right) implements ASTNode, Expression{}
record LogischeExpressionNode(Expression left,String operator,Expression right) implements ASTNode, Expression{}

record ReturnNode(Expression value) implements ASTNode, Statement {}