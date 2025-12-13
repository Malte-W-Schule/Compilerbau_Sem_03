//
// Created by Malte on 13.12.2025.
//

#ifndef BLATT_07_TOKEN_H
#define BLATT_07_TOKEN_H

class Token {
public:
    /**
     * Constructs a new token object.
     *
     * @param l is a pointer to the text of the token (to be copied)
     * @param r is the row in input where this token was found
     * @param c is the column in input where this token starts
     */
    Token(const char* l, int r, int c);

    /**
     * Destructs the token object and free's the stored lexem.
     */
    ~Token();

    char* getLexem();
    int getRow();
    int getCol();

private:
    char* lexem;    ///< Pointer to the text of the token
    int row;        ///< Row in input where this token was found
    int col;        ///< Column in input where this token starts
};


#endif //BLATT_07_TOKEN_H
