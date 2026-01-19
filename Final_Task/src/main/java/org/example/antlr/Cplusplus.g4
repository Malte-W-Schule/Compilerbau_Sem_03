grammar Cplusplus;

//#inlcude == kommentar
//kommentar == //
//block kommentar /* */
//#(Präprozessor) == Kommentar

// === Programm ===
program: stmt+ EOF;

// === Statement ===
stmt: if_stmt
    | while_stmt
    | decl
    | init
    | assign
    | f_call
    | f_decl
    | m_call
    | constructor_call
    | constructor_decl
    | class_decl
    | block
    | f_block
    | class_block
    ;

// === Expression ===
//expression / value
expr:
        arithmExpr
      | logExpr
      | f_call
      | m_call
      | constructor_call
      | f_call_no_semi
      ;

arithmExpr: // log op
      ae1=arithmExpr ('*') ae2=arithmExpr                       #mul_expr
    | ae1=arithmExpr ('/') ae2=arithmExpr                       #div_expr
    | ae1=arithmExpr ('%') ae2=arithmExpr                       #mod_expr
    | ae1=arithmExpr ('+') ae2=arithmExpr                       #add_expr
    | ae1=arithmExpr ('-') ae2=arithmExpr                       #sub_expr
    | LBRACK arithmExpr RBRACK                                  #aritgrouping
    | atom                                                      #atom_arithmExpr //todo was ist mit Vorzeichen?
    ;
//if ()
// 1*1 != 2*2
logExpr: //plus mal minus -> ari
     le1= logExpr ('==')le2=logExpr                             #doubleEqual
    | le1=logExpr ('!=') le2=logExpr                            #notEqual
    | le1=logExpr ('<')  le2=logExpr                            #lessThen
    | le1=logExpr ('>')  le2=logExpr                            #greaterThen
    | le1=logExpr ('<=') le2=logExpr                            #lessOrEqual
    | le1=logExpr ('>=') le2=logExpr                            #greaterOrEqual
    | le1=logExpr ('&&') le2=logExpr                            #and
    | le1=logExpr ('||') le2=logExpr                            #or
    | (NEGATE)? LBRACK logExpr RBRACK                           #loggrouping
    | arithmExpr                                                #aexpr
    | (NEGATE)? atom                                            #atom_logExpr
    ;

//Parameterloser Konstruktor und weitere Konstruktoren (jeweils ohne Initialisierungslisten), Verwendung nur als T x; (ruft T() auf) oder T x = T(args); (kein direkter Aufruf T x(args);!)
// Point p;
// p = Point(3, 4)


constructor_call: ID parameter_call';';
// T x; (ruft T()
constructor_decl: ID parameter_decl f_block;

// === Functions ===
//Überladung (Overloading) nur per exakt passender Signatur (Name + Anzahl + exakte Typen inkl. &‑Markierung)
// === Function Declaration ===
// void cast(type parameter1,...) { body (return*) }
// Class::Methode(){}
f_decl: VIRTUAL? type AND? ID parameter_decl (f_block|';'); //todo vllt auf virtual hinweisen
f_block: CLBRACK stmt* return? CRBRACK;

// === Function Call ===
f_call: f_call_no_semi ';';
f_call_no_semi : ID parameter_call; //todo zeigen

// === Parameter ===
parameter_decl:  LBRACK ( parameter (',' parameter)* )? RBRACK;
parameter : type AND? ID;
parameter_call:  LBRACK (  expr (',' expr)* )? RBRACK;

// === Bool ===
bool    :   'true' | 'false';

// === Block ===
block : CLBRACK stmt*  CRBRACK;


return: RETURN expr ';';

// === IF ===
//if( statement){ then block, else block }
if_stmt: IF LBRACK logExpr RBRACK then_block (else_block)?;
//else block
else_block: ELSE block;
//then block
then_block: block;

// === while ===:
while_stmt: WHILE LBRACK logExpr RBRACK block;

//
atom: STRING
    | CHAR
    | SIGN? INT  //todo assign zeigen, + - Vorzeichen
    | ID
    | LITERAL
    | bool
    ;

// === Type ===
type: 'string'
    | 'int'
    | 'bool'
    | 'char'
    | 'void'
    |  ID //todo Klassentypen erwähenen
    ;

// === Declaration ===
decl     :    type  AND?  ID ';' ;
// int& int int &

// === Initialisation ===
init    :   type AND? ID ASS expr ';';

// === Assign ===
//assign    zuweisung
assign  : (ID'.')? ID ASS expr ';' ;

//class_decl: CLASSS ID (':' ID)? CLBRACK ('public:')? (stmt)* CRBRACK';';
class_decl : CLASS ID (':' PUBLIC ID)?  class_block;
class_block : CLBRACK (PUBLIC ':')? stmt* CRBRACK ';';

// === Method call ===
//b.f()
m_call: ID '.' ID parameter_call;
//obj.f
//Feld-/Methodenzugriff: obj.f, obj.m(args)

// === Logic Operator ===
//logic operator    Arithmetik (nur int): +, -, *, /, % (binäre Ausdrücke); +, - (unäre Ausdrücke)
LOP     :   '+'|'-'|'*'|'/'|'%';
PLOP    :   '*'|'/';
LLOP    :   '+'|'-'|'%';
SIGN    :   '+'|'-';
// === Assign ===
// Zuweisung: =
ASS     :   '=';

// === Comparitor ===
// Vergleich: ==, !=, <, <=, >, >= (int und char; bool und string nur == und !=)
COMP    :   '==' | '!=' | '<' | '>' | '>=' | '<=' | '&&' | '||';

// === Logic ===
//2 operant (1 & 2) wird nicht ausgeführt wenn 1 bereits true bzw false definiert
NEGATE  :   '!';
// === Lexer-Rules ===
STRING : '"' (~["\\] | '\\' .)* '"';
//STRING  :   '"'.*'"';
INT     :   [0-9]+;

// === Token-Definitionen ===

// === Char ===
//char      Escapes in Literalen mit \, beispielsweise '\0' als einzelnes char
CHAR    :   '\'' . '\'';

// === Literal ===
//z.B.: \n, \0 usw...
LITERAL :   '\'' '\\'. '\''; //todo literale erwähnen

// === Token ===
IF      :   'if';
ELSE    :   'else';
WHILE   :   'while';

PUBLIC  :   'public';
PRIVATE :   'private';

CLASS   :   'class';
VOID    :   'void';

VIRTUAL :   'virtual';
AND     :   '&';
RETURN  :   'return';


// === Brackets ===
// left/right brackets
LBRACK  :   '(';
RBRACK  :   ')';

//curly left/right brackets
CLBRACK :   '{';
CRBRACK :   '}';

// === Comments & White Spaces ===

// === White Space ===
WS          :   [ \t\r\n]+ -> skip ;

// === Comment ===
// Zeilenweise Kommentare: // bis zum Zeilenende  //todo zeigen dass alles nötige ignoriert wird
COMMENT     :   '//'.*? '\n'  -> skip;
IMPORT      :   '#'.*? '\n'  -> skip;

// === Block Comment ===
// Block-Kommentare: /* bis zum */ (kann über mehrere Z'eilen gehen)
M_L_COMMENT :   '/*' .*? '*/' -> skip; //.*? nicht gierig

// === Präprozessor-Direktriven ===
// Präprozessor-Direktiven: # bis zum Zeilenende (soll als Kommentar behandelt werden)

// === ID ===
ID      :   [a-zA-Z][a-zA-Z0-9_]*;