#include<pthread.h>
#include<stdio.h>
#include <unistd.h>
#include<errno.h>
#include<stdlib.h>

pthread_t pthread_id[2]; //tableau hébergeant les numéros des threads
void *status;

struct thread_args {
	int arg_int;
	float arg_float;
	char* arg_char; 
};

int f_thread(void* args) {

	struct thread_args *thread_args = (struct arg_struct *) args;

	printf("entier %i\n", thread_args->arg_int);
	printf("float %f\n", thread_args->arg_float);
	printf("string %s\n", thread_args->arg_char);
	
	sleep(2);
	
	pthread_exit(0);
}

int main() {

	int i;
	struct thread_args thread_args;
	
	thread_args.arg_int = 1;
	thread_args.arg_float = 1.5;
	thread_args.arg_char = "bonjour";
	
	for (i=0; i<2; i++) {
		if (pthread_create(pthread_id+i,NULL, (void* ) f_thread, (void*) &thread_args) == -1)
			perror("Erreur lors de la création du thread\n");
	}

	for(i=1;i<3;i++) {
		(void) pthread_join(pthread_id[i], &status);
		printf("fin du thread %i - %li \n",i, (long int) status);
	}

	return 0;	
}
