    #include <iostream>

#include "Token.h"
#include "Tokenizer.h"
#include "SmartToken.h"
#include "RingBuffer.h"
void tokentest()
{
    std::cout << "=== TokenTest ===" << std::endl;

    Token t2("Zweiter_Token", 5, 20);
    std::cout << "Gelesenes (t2): " << t2.getLexem() << std::endl;

    Token t1(nullptr,1,2);
    std::cout << "Gelesen (t1): " << t1.getLexem() << std::endl;
}

void tokenizetest() {
    std::cout << "=== TokenizerTest ===" << std::endl;
    std::string input = "eins  zwei drei  vier";
    std::vector<Token> tokens;
    tokenize(input, tokens);
    for ( Token& t : tokens) {
        // WICHTIG: Fügt getRow() und getCol() zur Token-Klasse hinzu
        std::cout << "[" << t.getRow() << ":" << t.getCol() << "] "
                  << "'" << t.getLexem() << "'" << std::endl;
    }
}

void smarttokenTest() {
    SmartToken wuppie = SmartToken(new Token("wuppie", 1, 4));  // smart pointer wuppie

    // Access via smart pointer
    std::cout << wuppie.getLexem()   << std::endl;    // "wuppie"
}

void ringBufferTest() {
    std::cout << "=== RingBufferTest ===" << std::endl;
    RingBuffer rb = RingBuffer(5);
    rb.readBuffer();

    SmartToken smarttoken = SmartToken(new Token("smarttoken", 1, 4));
    std::cout << smarttoken.getLexem() << std::endl;
    rb.writeBuffer(smarttoken);
    rb.writeBuffer(smarttoken);
    rb.readBuffer();

}


    int main() {
        smarttokenTest();
    }

