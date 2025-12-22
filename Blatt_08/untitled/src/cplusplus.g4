grammar cplusplus;

//#inlcude == kommentar
//kommentar == //
//block kommentar /* */
//#(Präprozessor) == Kommentar

// === Programm ===
programm:   stmt EOF;

// === Statement ===
stmt: if_stmt
    | while_stmt
    | decl
    | init
    | assign
    ;

// === Expression ===
//expression / value
expr: LBRACK expr RBRACK            #grouping  //todo klammern grouping wie? wie logic calculations?
    | expr ('*' | '/' | '%') expr   #point_expr
    | expr ('+' | '-') expr         #add_expr
    | atom                          #atom_expr
    ;

/*
// === Logic Operation ===
lop_expr: mul_expr | add_expr;

line_expr: add_expr LOP add_expr;
point_expr:
*/

// === Logic Comparison ===
//comparrison expression
com_expr: expr LOP expr;

// === Bool ===
bool    :   'true' | 'false';

// === Block ===
block : CLBRACK stmt* expr* CRBRACK;

// === IF ===
//if( statement){ then block, else block }
if_stmt: IF LBRACK expr RBRACK then_block (else_block)? ;
//else block
else_block: ELSE CLBRACK stmt* CRBRACK;
//then block
then_block: CLBRACK stmt* CRBRACK;

// === while ===:
while_stmt: WHILE LBRACK com_expr RBRACK block;

//
atom: STRING
    | CHAR
    | INT
    | ID
    | LITERAL;


// === Type ===
type: 'string'
    | 'int'
    | 'bool'
    | 'char'
    | 'class';

// === Declaration ===
decl     :    type    ID;

// === Initialisation ===
init    :   type ID ASS expr;

// === Assign ===
//assign    zuweisung
assign  : ID ASS expr;

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
COMP    :   '==' | '!=' | '<' | '>' | '>=' | '<=';

// === Logic ===
//2 operant (1 & 2) wird nicht ausgeführt wenn 1 bereits true bzw false definiert
LOG     :   '&&'|'||'|'!';

// === Lexer-Rules ===
STRING  :   '"'.*'"';
ID      :   [a-zA-Z][a-zA-Z0-9]*;
INT     :   [0-9]+;

// === Token-Definitionen ===

// === Char ===
//char      Escapes in Literalen mit \, beispielsweise '\0' als einzelnes char
CHAR    :   '\'' . '\'';

// === Literal ===
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

// === Brackets ===
// left/right brackets
LBRACK  :   '(';
RBRACK  :   ')';

//curly left/right brackets
CLBRACK :   '{';
CRBRACK :   '}';

// === Comments & White Spaces ===

// === White Space ===
WS          :   [\t\r\n]+  -> skip;

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