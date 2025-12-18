//
// Created by Malte on 13.12.2025.
//

#ifndef BLATT_07_RINGBUFFER_H
#define BLATT_07_RINGBUFFER_H
#include "SmartToken.h"


class RingBuffer {
public:

    void PrintBuffer();

    /**
     * Constructor that creates a new ring buffer for max. `size` elements
     *
     * Initialises the attributes and allocates memory for `size` elements
     * of type `SmartToken` and let the pointer `elems` point to this new
     * array
     *
     * @param size is the max. number of elements that can be stored
     */
    RingBuffer(unsigned int size);

    /**
     * Destructor
     *
     * free's the dynamically allocated array `elems`
     */
    ~RingBuffer();

    /**
     * Reading the first (oldest) element
     *
     * If an element has been read, the `head` points to the next element
     * and `count` is decremented. The read element is **not** released.
     *
     * @return Returns (a copy of) the first (i.e. oldest) element of the
     * buffer, but does not (yet) release it; returns an empty `SmartToken`
     * if buffer is empty
     */
    SmartToken readBuffer();

    /**
     * Adding a new element
     *
     * Appends the new element to the end of the queue. If the buffer is
     * full, the oldest element will be overwritten by the new element. The
     * old element will take care of releasing its memory (smart pointer).
     *
     * @param data is a reference to the element to be added
     */
    void writeBuffer(const SmartToken& data);

private:
    unsigned int count;     ///< number of elements currently stored in the buffer
    unsigned int head;      ///< points to the beginning of the buffer (oldest element)
    unsigned int size;      ///< length of array `elems`
    SmartToken* elems;      ///< array with `size` places of type `SmartToken`, dynamically allocated
};


#endif //BLATT_07_RINGBUFFER_H