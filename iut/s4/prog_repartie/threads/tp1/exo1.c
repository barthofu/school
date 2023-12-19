#include<stdio.h>
#include<errno.h>
#include<pthread.h>
#include <unistd.h>
#include<stdlib.h>


pthread_t pthread_id[2];

void f_thread(int* u) {

	printf("ID du thread: %d\n Argument: %d\n", getpid(), *u);
	sleep(2);

	pthread_exit(0);
}

int main() {

	int i;
	
	for(i=0;i<2;i++){
		
		int a = i;
		
		if (pthread_create(pthread_id+i,NULL, (void* ) f_thread,&a) == -1)
			perror("Erreur lors de la création du thread\n");
	}

	printf("Main thread pid: %d\n", getpid());
	sleep(10); 
	
	return 0;
}
