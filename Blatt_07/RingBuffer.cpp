//
// Created by Malte on 13.12.2025.
//

#include "RingBuffer.h"

SmartToken RingBuffer::readBuffer() {
    if (count==0) {
        return SmartToken();
    }
    head++;
    count--;
    int index = (head + count) % size;
    return elems[index];
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
    head = (head + 1) % size;
    count++;
}

RingBuffer::~RingBuffer() {
    delete []elems;
}
