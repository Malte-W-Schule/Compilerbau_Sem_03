//
// Created by Malte on 13.12.2025.
//

#include "RefCounter.h"


RefCounter::RefCounter():n(0) {

}

void RefCounter::inc() {
    n++;
}

void RefCounter::dec() {
    n--;
}

bool RefCounter::isZero() const {
    if (n==0) {
        return true;
    }
    return false;
}
