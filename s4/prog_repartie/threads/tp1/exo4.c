#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>
#include <unistd.h>
#include<errno.h>


pthread_t pthread_id[10];
int tab[10];

void *status;


int f_thread(int* a) {
	
	printf("fin du thread %i \n", *a);
	return (0);
}

int main() {

	int i;
	
	for(i=1; i<11; i++) {
		
		tab[i] = i;
		if (pthread_create(pthread_id+i,NULL, (void* ) f_thread, &tab[i]) == -1)
			perror("Erreur lors de la création du thread\n");			
	}

	for(i=1; i<11; i++)
		(void) pthread_join(pthread_id[i], &status);
	
	exit(1);
}
