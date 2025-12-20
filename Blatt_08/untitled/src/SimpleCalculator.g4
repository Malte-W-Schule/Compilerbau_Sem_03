grammar SimpleCalculator;
options {
    language = Java;
    output = AST;
}

// Lexer-Rules
ID      : [a-zA-Z][a-zA-Z0-9]*;           // Identifikator
INT     : [0-9]+;                         // Ganzzahl
STRING  : \" ( [^"\\] | \\. )* \";        // Zeichenkette (mit Escape-Sequenzen)
WS      : [ \t\r\n]+ -> skip;             // Whitespaces ignorieren

// Parser-Rules
program: expr+;

expr: term ( ('+' | '-' | '*' | '/' | '+' | '-') term )*; // Erweiterte Operatoren
term: factor ( ('+' | '-' | '*' | '/') factor )*;
factor: INT | ID | STRING | '(' expr ')' | stringLiteral;

stringLiteral: STRING; // Zeichenkette als Ausdruck

// Semantische Aktionen (z. B. für String-Operationen)
stringLiteral returns [String value] :
    STRING
    {
        $value = $STRING.text; // Wert der Zeichenkette
    }
;

// Beispiel für String-Verkettung
concatExpr: stringLiteral ('+' stringLiteral)*;

// Beispiel für String-Operationen (z. B. Länge)
stringLiteral returns [int length] :
    STRING
    {
        $length = $STRING.text.length(); // Länge der Zeichenkette
    }
;

// Optionale Erweiterung: String-Operationen
stringLiteral returns [String value] :
    STRING
    {
        $value = $STRING.text;
    }
;

// Beispiel für String-Verkettung in einem Ausdruck
expr returns [String value] :
    concatExpr
    {
        $value = $concatExpr.value; // Verkettung von Strings
    }
;

// Beispiel für String-Operationen (z. B. Länge)
stringLiteral returns [int length] :
    STRING
    {
        $length = $STRING.text.length(); // Länge der Zeichenkette
    }
;

// Beispiel für String-Operationen (z. B. Uppercase)
stringLiteral returns [String value] :
    STRING
    {
        $value = $STRING.text.toUpperCase(); // Uppercase der Zeichenkette
    }
;
