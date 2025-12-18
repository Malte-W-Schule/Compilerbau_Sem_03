//
// Created by Malte on 13.12.2025.
//

#ifndef BLATT_07_REFCOUNTER_H
#define BLATT_07_REFCOUNTER_H


class RefCounter {
public:
    /**
     * Default constructor
     */
    RefCounter();

    /**
     * Increment count
     */
    void inc();

    /**
     * Decrement count
     */
    void dec();

    /**
     * Compare the counter with zero
     *
     * @return true if n==0, false otherwise
     */
    bool isZero() const;

    // Hide copy constructor and assignment operator
    RefCounter(const RefCounter&) = delete;
    RefCounter& operator=(const RefCounter&) = delete;

//private:
    unsigned int n;     ///< How many SmartToken share ownership of "our" object?
};


#endif //BLATT_07_REFCOUNTER_H