#include "Token.h"
#include <string>
#include <vector>
#include <cctype> // Für std::isspace

void tokenize(const std::string& input, std::vector<Token>& tokens) {
    int index = 0;
    int row = 1;
    int col = 1;
    int startWordIndex = 0;

    while (index < input.length()) { //input loopen

        while (index < input.length() && std::isspace(input[index])) {//whitespaced

            if (input[index] == '\n') {
                row++;
                col = 1;
            } else {
                col++;
            }
            index++;
        }
        //token
        startWordIndex = index;
        int startCol = col; 

        while (index < input.length() && !std::isspace(input[index])) {
            index++;
            col++;
        }
        //index nun an wortende
        if (index > startWordIndex) {

            std::string word = input.substr(startWordIndex, index - startWordIndex);

            tokens.emplace_back(word.c_str(), row, startCol);

        }

    }
}