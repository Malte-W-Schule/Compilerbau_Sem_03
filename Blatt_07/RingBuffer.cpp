//
// Created by Malte on 13.12.2025.
//

#include "RingBuffer.h"

#include <iostream>
#include <ostream>

SmartToken RingBuffer::readBuffer() {
    if (count==0) {
        return nullptr;
    }
    SmartToken s = elems[head];
    head = (head +1 ) % size;
    count--;
    return s;
}

void RingBuffer::PrintBuffer() {
    int index = 0;
    std::cout << "head:" << head << "count:" << count << std::endl;

    while (index < count) {
        std::cout << elems[((index+head)%size)].getLexem() << std::endl;
        index = (index+1) % size;
    }

    std::cout << "------------"  << std::endl;

}

//construktor
RingBuffer::RingBuffer(unsigned int size)
    : size(size),
      elems(new SmartToken[size]),
      head(0),
      count(0)
{
}

void RingBuffer::writeBuffer(const SmartToken &data) {
    elems[((head + count) % size)] = data;
    //head = (head + 1) % size;
    count = (count+1);

    if (count > size) {
        head = (head + 1) % size;
        count = size;
    }
}

RingBuffer::~RingBuffer() {
    delete []elems;
}
