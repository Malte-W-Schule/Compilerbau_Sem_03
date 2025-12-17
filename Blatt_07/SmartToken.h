//
// Created by Malte on 13.12.2025.
//

#ifndef BLATT_07_SMARTTOKEN_H
#define BLATT_07_SMARTTOKEN_H
#include "RefCounter.h"
#include "Token.h"

class SmartToken {
public:
    /**
     * Constructor
     *
     * Constructs a new smart pointer from a raw pointer, sets the reference
     * counter to 1.
     *
     * @param p is a raw pointer to the token to be shared
     */
    SmartToken(Token* p = nullptr);

    /**
     * Copy constructor
     *
     * Constructs a new smart pointer from another smart pointer, increments
     * the reference counter.
     *
     * @param sp is another smart pointer
     */
    SmartToken(const SmartToken& sp);

    /**
     * Destructor
     *
     * Decrements the reference counter. If it reaches zero, the shared token
     * will be free'd.
     */
    ~SmartToken();

    /**
     * Assignment
     *
     * Changes the shared token, thus we need first to perform something like
     * the destructor, followed by something like the constructor.
     *
     * @param sp is another smart pointer
     */
    SmartToken& operator=(const SmartToken& sp);


    char* getLexem();
private:
    Token* pObj;        ///< Pointer to the current shared token
    RefCounter* rc;     ///< Pointer to the reference counter (used for the current token)
};



#endif //BLATT_07_SMARTTOKEN_H