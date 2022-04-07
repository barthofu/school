#include<pthread.h>
#include<stdio.h>
#include <unistd.h>
#include<stdlib.h>
#include<errno.h>


pthread_t pthread_id[2];

void *status;

int f_thread(int* u) {
	
	printf("Je suis le thread d’identite %d\n", getpid());
	printf("Et mon entier en argument est %d\n", *u);
	
	sleep(2);
	
	return (0);
}

int main() {

	int i;

	for (i=0; i<2; i++) {
		
		int a = i;
		
		if (pthread_create(pthread_id+i,NULL, (void* ) f_thread, &a) == -1)
			perror("Erreur lors de la création du thread\n");
	}

	printf("Je suis le processus initial de pid: %d\n",getpid());

	for (i=1; i<3; i++) {
		(void) pthread_join(pthread_id[i], &status);
		printf("fin du thread %i - %li \n",i, (long int) status);
	}

	exit(1);
}
