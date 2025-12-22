grammar test;

// === Programmstruktur ===
// Ein Programm besteht aus Deklarationen (Funktionen/Klassen) oder Statements (REPL-Support)
programm: (content)* EOF;

content : f_decl
        | class_decl
        | stmt
        | PREP
        ;

// === Statements ===
stmt    : block                                     #blockStmt
        | type '&'? ID (ASS expr)? ';'              #declStmt   // T x; oder T& x = y;
        | expr ';'                                  #exprStmt   // inkl. f_call() und Zuweisung
        | IF LBRACK expr RBRACK stmt (ELSE stmt)?   #ifStmt
        | WHILE LBRACK expr RBRACK stmt             #whileStmt
        | 'return' expr? ';'                        #returnStmt
        ;

block   : CLBRACK stmt* CRBRACK;

// === Expressions (Präzedenz von oben nach unten) ===
expr    : LBRACK expr RBRACK                        #groupingExpr
        | atom                                      #atomExpr
        | ID '.' ID                                 #memberExpr       // obj.field
        | ID '.' ID parameter_call                  #methodCallExpr   // obj.method(args)
        | ID parameter_call                         #funcCallExpr     // f(args)
        | <assoc=right> (PLUS|MINUS|NOT) expr       #unaryExpr
        | expr (MUL|DIV|MOD) expr                   #mulExpr
        | expr (PLUS|MINUS) expr                    #addExpr
        | expr COMP expr                            #relExpr
        | expr AND expr                             #andExpr
        | expr OR expr                              #orExpr
        | <assoc=right> ID ASS expr                 #assignExpr       // a = b = 5
        ;

// === Klassen & Funktionen ===
class_decl : CLASS ID (':' PUBLIC ID)? CLBRACK
                (PUBLIC ':')?
                (field_decl | f_decl | constructor_decl)* CRBRACK ';';

field_decl : type ID ';';

constructor_decl : ID parameter_decl block; // T() { ... }

f_decl     : VIRTUAL? type ID parameter_decl block;

parameter_decl : LBRACK (type '&'? ID (',' type '&'? ID)*)? RBRACK;
parameter_call : LBRACK (expr (',' expr)*)? RBRACK;

// === Typen & Atome ===
type    : 'int' | 'bool' | 'char' | 'string' | 'void' | ID; // ID für Klassennamen

atom    : INT
        | BOOL
        | CHAR
        | STRING
        | ID;

// === Lexer Regeln ===

// Keywords
IF      : 'if';
ELSE    : 'else';
WHILE   : 'while';
CLASS   : 'class';
PUBLIC  : 'public';
VIRTUAL : 'virtual';

// Operatoren
ASS     : '=';
COMP    : '==' | '!=' | '<' | '>' | '<=' | '>=';
AND     : '&&';
OR      : '||';
NOT     : '!';
PLUS    : '+';
MINUS   : '-';
MUL     : '*';
DIV     : '/';
MOD     : '%';

// Brackets
LBRACK  : '(';
RBRACK  : ')';
CLBRACK : '{';
CRBRACK : '}';

// Literale
BOOL    : 'true' | 'false';
INT     : [0-9]+;
STRING  : '"' ( '\\"' | . )*? '"';
CHAR    : '\'' ( '\\' . | . ) '\'';
ID      : [a-zA-Z_][a-zA-Z0-9_]*;

// Kommentare & Präprozessor
PREP        : '#' ~[\r\n]* -> skip;
COMMENT     : '//' ~[\r\n]* -> skip;
M_L_COMMENT : '/*' .*? '*/' -> skip;
WS          : [ \t\r\n]+    -> skip;