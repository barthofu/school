#include <unistd.h>
#include <string.h>

int main () {
    
    char buf[100];
    char *msg="you wrote:";

    while (1) {
        int n;

        n = read(0, buf, sizeof(buf));
        write(1, msg, strlen(msg));
        write(1, buf, n);
    }
}