#include <string.h>

void remove_spaces(char *line) {
    while (*line) {
        if (*line == ' ') {
            // Shift the rest of the line to the left by one character
            memmove(line, line + 1, strlen(line));
        } else {
            // Advance to the next character
            line++;
        }
    }
}