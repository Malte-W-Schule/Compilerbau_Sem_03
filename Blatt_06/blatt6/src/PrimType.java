public enum PrimType {
    INT,        // Ganze Zahlen (z.B. 42)
    BOOL,       // Wahrheitswerte (true/false)
    VOID,       // Kein Rückgabewert (für Funktionen)
    UNKNOWN,    // Falls ein Typ nicht aufgelöst werden kann (Fehlerfall)
    STRING,
    ERROR       // Expliziter Fehlertyp (optional)
}