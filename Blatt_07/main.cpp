    #include <iostream>

#include "Token.h"
#include "Tokenizer.h"
#include "SmartToken.h"
#include "RingBuffer.h"

void tokentest()
{
    std::cout << "=== TokenTest ===" << std::endl;

    Token t2("Zweiter Token", 5, 20);
    std::cout << "Gelesenes (t2): " << t2.getLexem() << std::endl;

    Token t1(nullptr,1,2);
    std::cout << "Gelesen (t1): " << t1.getLexem() << std::endl;
}

void tokenizetest() {
    std::cout << "=== TokenizerTest ===" << std::endl;
    std::string input = "eins zwei drei vier";
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
    {
        SmartToken wuppiePointer = wuppie;

        std::cout <<  wuppie.rc->n << std::endl;
        std::cout <<  wuppiePointer.rc->n << std::endl;

        //delete wuppie;
    }
    std::cout <<  wuppie.rc->n << std::endl;
    // Access via smart pointer
    std::cout << wuppie.getLexem()   << std::endl;    // "wuppie"
}

void ringBufferTest() {
    std::cout << "=== RingBufferTest ===" << std::endl;
    RingBuffer rb = RingBuffer(5);
    rb.readBuffer();


    SmartToken smarttoken1 = SmartToken(new Token("1", 1, 4));
    SmartToken tokentest2 = SmartToken(new Token("2", 1, 4));
    SmartToken tokentest3 = SmartToken(new Token("3", 253,23));
    SmartToken tokentest4 = SmartToken(new Token("4", 253,23));
    SmartToken tokentest5 = SmartToken(new Token("5", 253,23));
    SmartToken tokentest6 = SmartToken(new Token("6", 253,23));


    rb.writeBuffer(smarttoken1);

    rb.PrintBuffer();
    rb.writeBuffer(tokentest2);
    rb.PrintBuffer();
    rb.writeBuffer(tokentest3);
    rb.PrintBuffer();
    rb.writeBuffer(tokentest4);
    rb.PrintBuffer();
    rb.writeBuffer(tokentest5);
    rb.PrintBuffer();
    //5
    rb.writeBuffer(tokentest6);

    rb.PrintBuffer();
/*
    std::cout << rb.readBuffer().getLexem() << std::endl;

    std::cout << rb.readBuffer().getLexem() << std::endl;
    std::cout << rb.readBuffer().getLexem() << std::endl;
    std::cout << rb.readBuffer().getLexem() << std::endl;
    std::cout << rb.readBuffer().getLexem() << std::endl;
    std::cout << rb.readBuffer().getLexem() << std::endl;
    **/


}


    int main() {
        ringBufferTest();
    }

