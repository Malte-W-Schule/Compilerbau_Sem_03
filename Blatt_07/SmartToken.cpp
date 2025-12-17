//
// Created by Malte on 13.12.2025.
//

#include "SmartToken.h"

SmartToken::SmartToken(Token* p):pObj(p),rc(new RefCounter()) {
    rc->inc();
}

SmartToken::SmartToken(const SmartToken &sp) {
    pObj = sp.pObj;
    rc = sp.rc;
    rc->inc();
}

char *SmartToken::getLexem() {
    return pObj->getLexem();
}

SmartToken &SmartToken::operator=(const SmartToken &sp) {

    if (this == &sp) {
        return *this;
    }

    //dekonstrutor
    if (rc != nullptr) {
        rc->dec();

        if (rc->isZero()) {
            delete pObj;
            delete rc;
        }
    }
    //consturktor
   *this;

    pObj = sp.pObj;
    rc = sp.rc;
    if (rc!=nullptr) {
        rc->inc();
    }
    return *this;

}


SmartToken::~SmartToken() {
    if (rc != nullptr) {
        rc->dec();

        if (rc->isZero()) {
            delete pObj;
            delete rc;
        }
    }
}
