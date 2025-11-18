

public class Token {

    public final TokenType type;
    public final String value;

    public final int colum;
    public final int row;

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public int getColum() {
        return colum;
    }

    public int getRow(){
        return row;
    }

    public Token(TokenType type, String value,int colum,int row) {
        this.type = type;
        this.value = value;
        this.colum = colum;
        this.row = row;
    }

}
