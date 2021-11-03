#include <stdio.h>

int main(int argc, char **argv) {

    for (int i = 1; i < argc; ++i) {

        int taille;

        while (argv[i][taille] != "/0") {
            taille++;
        }
        
        write(1, argv[i], taille);
        printf("%s\n",argv[i]);
    }
}