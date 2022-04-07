#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <errno.h>
#include <sys/types.h>
#include <unistd.h>
#include <signal.h>
#include <string.h>
#include <unistd.h>
#include <stdio.h>
#include <time.h>

void sig_handler(int signum) {

	printf("\nFin du programme");
}

int main() {
	
	time_t base_time = time(NULL);
	unsigned long now;
	unsigned long diff;

	while (1) {

		now = time(NULL);
		diff = now - base_time;

		printf("Secondes passées: %ld", diff);
		
		if (diff >= 10)			
			signal(SIGINT, sig_handler);
		
		printf("\nSalut !");
		
		fflush(stdout);

		sleep(1);
	}
	
	return 0;
}
