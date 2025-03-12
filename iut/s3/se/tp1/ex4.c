//https://openclassrooms.com/forum/sujet/comment-ca-fonctionne-12569

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

#define MAX 1000

int main (int argc, char** argv) {

    int f1, f2, sizeBuff;
    char buff[MAX];

    f1 = open(argv[1], O_RDONLY, 0744);
    f2 = open(argv[2], O_WRONLY | O_APPEND | O_CREAT, 0744);
    if (f1 == -1 || f2 == -1)
        return 1;
    
    do {

        sizeBuff = read(f1, buff, MAX);
        write(f2, buff, sizeBuff);
    } while (sizeBuff > 0);


    close(f1);
    close(f2);
    
    return 0;
}