#include<pthread.h>
#include<stdio.h>
#include <unistd.h>
#include<errno.h>
#include<stdlib.h>


pthread_t pthread_id[2]; //tableau hébergeant les numéros des threads


void *status;

struct arg_struct {
	int arg_int;
	float arg_float;
	char* arg_char; 
};

int f_thread(void* arguments) {

	struct arg_struct *args = (struct arg_struct *)arguments;

	printf("entier %i\n", args->arg_int);
	printf("float %f\n", args->arg_float);
	printf("string %s\n", args->arg_char);
	
	sleep(2);
	
	return (0);
}

int main() {

	int i;
	struct arg_struct args;
	
	args.arg_int = 1;
	args.arg_float = 1.5;
	args.arg_char = "bonjour";
	
	for (i=0; i<2; i++) {
		if (pthread_create(pthread_id+i,NULL, (void* ) f_thread, (void*) &args) == -1)
			perror("Erreur lors de la création du thread\n");
	}

	for(i=1;i<3;i++) {
		(void) pthread_join(pthread_id[i], &status);
		printf("fin du thread %i - %li \n",i, (long int) status);
	}

	exit(1);	
}
