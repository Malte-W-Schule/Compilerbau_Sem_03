public enum TokenType {
    // 1. Spezielle Zeichen
    LPAREN,     // '('
    RPAREN,     // ')'

    // 2. Literale (Werte)
    INTEGER, // Z.B. 42
    STRING,  // Z.B. "hello"
    BOOLEAN_TRUE,    // 'true'
    BOOLEAN_FALSE,   // 'false'

    // 3. Schlüsselwörter (Funktionen/Kontrollstrukturen)
    IF,      // 'if'
    DO,      // 'do'
    DEF,     // 'def'
    DEFN,    // 'defn'
    LET,     // 'let'
    LIST,    // 'list'

    // 4. Eingebaute Funktionen und Operatoren (Identifikatoren)
    PLUS,    // '+' (auch als Funktion/Operator)
    MINUS,   // '-' (auch als Funktion/Operator)
    MULT,    // '*' (auch als Funktion/Operator)
    DIV,     // '/' (auch als Funktion/Operator)
    EQ,      // '=' (Vergleichsoperator)
    GT,      // '>' (Vergleichsoperator)
    LT,      // '<' (Vergleichsoperator)

    PRINT, // 'print'
    STR,   // 'str'
    NTH,   // 'nth'
    HEAD,  // 'head'
    TAIL,  // 'tail'

    // 5. Allgemeine Bezeichner (Variablennamen, Funktionsnamen)
    IDENTIFIER, // Z.B. 'foo', 'x', oder benutzerdefinierte Funktionsnamen

    // 6. Sonstige/Ende
    EOF,        // Ende der Eingabe (End Of File)
    ERROR,       // Lexing-Fehler (Optional, kann auch durch Exception gelöst werden)
    NAME
}