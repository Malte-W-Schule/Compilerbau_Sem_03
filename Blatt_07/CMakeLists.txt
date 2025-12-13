cmake_minimum_required(VERSION 4.1)
project(Blatt_07)

set(CMAKE_CXX_STANDARD 20)

add_executable(Blatt_07 main.cpp
        Token.cpp
        Token.h
        Tokenizer.cpp
        Tokenizer.h
        SmartToken.cpp
        SmartToken.h
        RefCounter.cpp
        RefCounter.h
        RingBuffer.cpp
        RingBuffer.h
)
