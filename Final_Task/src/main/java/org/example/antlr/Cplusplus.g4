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
    ;

// === Expression ===
//expression / value
expr: (NEGATE)? LBRACK expr RBRACK            #grouping
    | expr ('*') expr                         #mul_expr
    | expr ('/') expr                         #div_expr
    | expr ('%') expr                         #mod_expr
    | expr ('+') expr                         #add_expr
    | expr ('-') expr                         #sub_expr
    | expr ('==') expr                        #doubleEqual
    | expr ('!=') expr                        #notEqual
    | expr ('<') expr                         #lessThen
    | expr ('>') expr                         #greaterThen
    | expr ('<=') expr                        #lessOrEqual
    | expr ('>=') expr                        #greaterOrEqual
    | expr ('&&') expr                        #and
    | expr ('||') expr                        #or
    | (NEGATE)? atom                          #atom_expr
    ;

//a<b<c
//Parameterloser Konstruktor und weitere Konstruktoren (jeweils ohne Initialisierungslisten), Verwendung nur als T x; (ruft T() auf) oder T x = T(args); (kein direkter Aufruf T x(args);!)
constructor_call: ID ID';';
// T x; (ruft T()
constructor_decl: ID parameter_decl block;

// === Functions ===
//Überladung (Overloading) nur per exakt passender Signatur (Name + Anzahl + exakte Typen inkl. &‑Markierung)
// === Function Declaration ===
// void cast(type parameter1,...) { body (return*) }
// Class::Methode(){}
f_decl: VIRTUAL? type AND? ID parameter_decl (block|';');
// === Function Call ===
f_call: ID parameter_call ';';
// === Parameter ===
parameter_decl:  LBRACK ( parameter (',' parameter)* )? RBRACK;
parameter : type AND? ID;
parameter_call:  LBRACK (  expr (',' expr)* )? RBRACK;

/*
// === Logic Operation ===
lop_expr: mul_expr | add_expr;
T& x = expr; T& p
line_expr: add_expr LOP add_expr;
point_expr:
*/  //a < v !a < v   a < !v    !( a < v)    !a = !b
// !a != !b   a < v && a > v   a  < v && c     ( a && b) || c     a + v == c && a < c
// === Logic Comparison ===
//comparrison expression
/*
com_expr: com_expr COMP com_expr
        | LBRACK com_expr COMP com_expr RBRACK //!( a == b)
        | (NEGATE)? (bool|ID)
        | (NEGATE)? LBRACK (bool|ID) RBRACK
        |  NEGATE com_expr COMP com_expr
        ;
*/

// Die Hauptebene für Vergleiche
/*com_expr
    : primary_expr (COMP primary_expr)*
    ;

// Die Ebene für einzelne Werte, Klammern und Negationen
primary_expr //todo nich gut, überarbeiten im bezug auf verschachtelung/negierung
    : //(NEGATE)? atom doppelt gemoppelt weil expr führt zu atom
    | (NEGATE)? LBRACK com_expr RBRACK //prim == !(prim == prim)
    | //(NEGATE)? LBRACK expr RBRACK
    | (NEGATE)? expr
    ;*/

// === Bool ===
bool    :   'true' | 'false';

// === Block ===
block : CLBRACK stmt* return? CRBRACK;

return: 'return' expr ';';
// === IF ===
//if( statement){ then block, else block }
if_stmt: IF LBRACK expr RBRACK then_block (else_block)?;
//else block
else_block: ELSE block;
//then block
then_block: block;

// === while ===:
while_stmt: WHILE LBRACK expr RBRACK block;

//
atom: STRING
    | CHAR
    | INT
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
    ;

// === Declaration ===
decl     :    type  AND?  ID ';' ;
// int& int int &

// === Initialisation ===
init    :   type AND? ID ASS expr ';';

// === Assign ===
//assign    zuweisung
assign  : ID ASS expr ';' ;

//Klassen, Einfach-Vererbung (genau eine optionale Basisklasse), Polymorphie:
  //class A { public: /* Felder + Methoden */ } mit Feldern und Methoden (alles “public” sichtbar)
  //Felder können vom Typ her Basistypen oder Klassen sein
  //Parameterloser Konstruktor und weitere Konstruktoren (jeweils ohne Initialisierungslisten), Verwendung nur als T x; (ruft T() auf) oder T x = T(args); (kein direkter Aufruf T x(args);!)
  //Methoden können als virtual deklariert werden
  //class D : public B { public: /* Felder + Methoden */ }: Vererbung mit genau einer Basisklasse, keine Zyklen

// === Classes ===
//class_decl: CLASSS ID (':' ID)? CLBRACK ('public:')? (stmt)* CRBRACK';';
/*
class_decl:
    CLASS ID
    (':' access_specifier ID)?  // z. B. `: public Base`
    CLBRACK
    class_body
    CRBRACK
    ';';

access_specifier: 'public' | 'private';

class_body:
    (access_specifier ':' (stmt)+ )*
    | (stmt)*;
*/
//class_decl: CLASSS ID (':' ID)? CLBRACK ('public:')? (stmt)* CRBRACK';';
class_decl : CLASS ID (':' PUBLIC ID)? CLBRACK
(PUBLIC ':')?
(stmt)* CRBRACK ';';

// === Method call ===
m_call: ID '.' ID parameter_call?;
//obj.f
//Feld-/Methodenzugriff: obj.f, obj.m(args)

// SmartToken::SmartToken(Token* p):pObj(p),rc(new RefCounter()) {
   //    rc->inc();
   //}
/*
else:
while:
return:
class:
void:
public:
virtual:
Deklaration T x; und Initialisierung T x = expr;
Nur lokale Variablen (keine globalen Variablen)
*/


// === Logic Operator ===
//logic operator    Arithmetik (nur int): +, -, *, /, % (binäre Ausdrücke); +, - (unäre Ausdrücke)
LOP     :   '+'|'-'|'*'|'/'|'%';
PLOP    :   '*'|'/';
LLOP    :   '+'|'-'|'%';

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
LITERAL :   '\'' '\\'. '\'';

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
// Zeilenweise Kommentare: // bis zum Zeilenende
COMMENT     :   '//'[.*? \n]  -> skip;
IMPORT      :   '#'[.*? \n]  -> skip;

// === Block Comment ===
// Block-Kommentare: /* bis zum */ (kann über mehrere Zeilen gehen)
M_L_COMMENT :   '/*' .*? '*/' -> skip; //.*? nicht gierig

// === Präprozessor-Direktriven ===
// Präprozessor-Direktiven: # bis zum Zeilenende (soll als Kommentar behandelt werden)
PREP        :   '#'[.*? \n] -> skip;

// === ID ===
ID      :   [a-zA-Z][a-zA-Z0-9]*;