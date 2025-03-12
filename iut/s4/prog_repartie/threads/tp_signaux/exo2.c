#include <pthread.h>
#include <errno.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <time.h>

pid_t pid_1;
pid_t pid_2;

void sig_handler2(int sig_num) {

	printf("\nFin du fils 2 (pid: )%d)\n", pid_2);
}

void sig_handler_1(int sig_num) {

	printf("\nFin du fils 1 (pid: %d)\n", pid_1);
	
	signal(SIGCHLD, sig_handler2);
}


int main() {

	pid_1 = fork();

	if (pid_1 == 0) {

		sleep(2);
		printf("\nFils 1 -> 2 secondes d'attente");
		fflush(stdout);
	}

	if (pid_1 > 0) {

		pid_2 = fork();

		if (pid_2 == 0) {

			sleep(3);
			printf("\nFils 2 -> 3 secondes d'attente\n");
			fflush(stdout);

		} else if (pid_2 > 0) {

			printf("\nPère\n");
			fflush(stdout);

			signal(SIGCHLD, sig_handler_1);
			
			while (wait(NULL) > 0){

			}
			
		}
	}
	
	return 0;
}
