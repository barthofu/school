#include <stdio.h>
#include <unistd.h>

int main(int argc, char** argv) {
   
   char tab[] = "hello world !";
   write (1, tab,13);

   return 0; 

}