#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <sys/types.h>
#include <string.h>
#include <unistd.h>

pthread_t thread_1; 
pthread_t thread_2; 

struct thread {
    int thread_id;
};

void *f_thread_1(void *args) {

    struct thread *thread_args = (struct thread *) args;

    printf("Message: %d\n", thread_args->thread_id);

    pthread_exit(0);
}

void *f_thread_2(void *args) {

    struct thread *thread_args = (struct thread *) args;

    printf("Message: %d\n", thread_args->thread_id);

    pthread_exit(0);
}

int main() {

    struct thread thread_args_1 = { thread_id: 1 };
    struct thread thread_args_2 = { thread_id: 2 };
    
    long resultat_1;
    long resultat_2;
    
    printf("PID Main: %d\n", getpid());

    // Thread 1
    if (pthread_create(&thread_1, NULL, (void *)f_thread_1, (void *) &thread_args_1) == -1)
        perror("Erreur lors de la création du thread\n");

    if (pthread_join(&thread_2, (void *) &resultat_1))
        printf("Thread 1 terminé\n");

    // Thread 2
    if (pthread_create(&thread_2, NULL, (void *)f_thread_2, (void *) &thread_args_2) == -1)
        perror("Erreur lors de la création du thread\n");

    if (pthread_join(&thread_2, (void *) &resultat_2))
        printf("Thread 2 terminé\n");

    printf("=====\nFin");

    return 0;
}