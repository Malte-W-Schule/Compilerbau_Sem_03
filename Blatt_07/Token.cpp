//
// Created by Malte on 13.12.2025.
//


#include "Token.h"

#include <cstring>
#include <iostream>
#include <ostream>
#include <string>

Token::Token(const char *l, int r, int c):
    row(r),                         //einfache parameter
    col(c){

    if (l != nullptr) {

        const char* text;                               //char pointer erstellen

        size_t laenge = strlen(l)+1;                    //länge von l +1 für string end

        lexem = new char[laenge];                       //neuen char länge l erstellen

        std::copy(l,(l+laenge),this->lexem);    //l in lexem copy pasten
    }
    else {
        lexem = nullptr;
    }
}

Token::~Token() {
    if (lexem != nullptr) {
        delete[] lexem;
    }

}

char *Token::getLexem() {
    return this->lexem;
}

int Token::getRow() {
    return this->row;
}

int Token::getCol() {
    return this->col;
}
#include "Token.h"