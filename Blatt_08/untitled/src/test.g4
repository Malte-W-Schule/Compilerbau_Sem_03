grammar test;

// === Programm ===
programm: (content)+ EOF;

// Erlaubt Definitionen und Statements auf oberster Ebene (für REPL wichtig)
content: class_decl | f_decl | stmt | PREP;

// === Statement ===
stmt: if_stmt
    | while_stmt
    | block
    | decl      // T x;
    | init      // T x = expr;
    | assign    // x = expr;
    | expr ';'  // Ausdrücke als Statement (z.B. f_call)
    | 'return' expr? ';'
    ;

// === Expression ===
// Hierarchie von oben (hoch) nach unten (niedrig)
expr: LBRACK expr RBRACK            #grouping
    | (PLUS|MINUS|NOT) expr         #unary_expr
    | expr (MUL|DIV|MOD) expr       #point_expr
    | expr (PLUS|MINUS) expr        #line_expr
    | expr COMP expr                #comp_expr
    | expr LOG_AND expr             #and_expr
    | expr LOG_OR expr              #or_expr
    | ID ASS expr                   #assign_expr
    | m_call                        #method_call_expr
    | f_call_expr                   #f_call_expr_
    | atom                          #atom_expr
    ;

// Hilfsregeln für Funktionsaufrufe in Expressions (ohne Semikolon)
f_call_expr: ID parameter_call;
m_call: ID '.' ID parameter_call?;

// === Functions ===
// Definitionen
f_decl: VIRTUAL? type ID parameter_decl block;

// Parameter
parameter_decl: LBRACK ( type '&'? ID (',' type '&'? ID)* )? RBRACK;
parameter_call: LBRACK ( expr (',' expr)* )? RBRACK;

// === Block ===
block : CLBRACK stmt* CRBRACK;

// === Kontrollfluss ===
if_stmt: IF LBRACK expr RBRACK stmt (ELSE stmt)? ;
while_stmt: WHILE LBRACK expr RBRACK stmt;

// === Typen & Atome ===
type: 'string' | 'int' | 'bool' | 'char' | 'void' | ID;

atom: STRING | CHAR | INT | ID | BOOL;

// === Deklaration / Initialisierung ===
decl     : type '&'? ID ';' ;
init     : type '&'? ID ASS expr ';';
assign   : ID ASS expr ';' ;

// === Classes ===
// Nur Felder, Methoden oder Konstruktoren in der Klasse erlaubt
class_decl: CLASS ID (':' PUBLIC ID)? CLBRACK
               (PUBLIC ':')?
               (member_decl)* CRBRACK ';';

member_decl: f_decl | constructor_decl | (type ID ';');

constructor_decl: ID parameter_decl block;

// === Lexer-Rules ===

// Operatoren (Einzeln für die Präzedenz in expr)
PLUS  : '+';
MINUS : '-';
MUL   : '*';
DIV   : '/';
MOD   : '%';
NOT   : '!';
LOG_AND : '&&';
LOG_OR  : '||';
ASS   : '=';

COMP  : '==' | '!=' | '<' | '>' | '>=' | '<=';

IF      : 'if';
ELSE    : 'else';
WHILE   : 'while';
PUBLIC  : 'public';
CLASS   : 'class';
VIRTUAL : 'virtual';
BOOL    : 'true' | 'false';

ID      : [a-zA-Z_][a-zA-Z0-9_]*;
INT     : [0-9]+;
STRING  : '"' ( '\\"' | . )*? '"';
CHAR    : '\'' ( '\\' . | . ) '\'';

LBRACK  : '(';
RBRACK  : ')';
CLBRACK : '{';
CRBRACK : '}';

// === White Space & Comments ===
WS          : [ \t\r\n]+  -> skip;

// Korrigierte Kommentare: ~[\r\n]* bedeutet "alles außer Zeilenumbruch"
COMMENT     : '//' ~[\r\n]* -> skip;
M_L_COMMENT : '/*' .*? '*/' -> skip;
PREP        : '#' ~[\r\n]* -> skip; // Präprozessor wie Kommentar