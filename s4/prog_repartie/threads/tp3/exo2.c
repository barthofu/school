#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <pthread.h>
#include <string.h>
#include <semaphore.h>
#include <sys/types.h>
#include <unistd.h>

#define NBR_THREADS 10

long solde = 0;
int barrier = 0;

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_t pthread_id[NB_THREADS];
sem_t sem;

struct thread {
    long id;
};

void *f_thread(void *args_thread_r) {

    struct thread *currThread = (struct thread *)args_thread_r;
    int rand_number = rand() % 10;
    int i;
    
    barrier++;

    printf("Thread n°%ld lancé\n", currThread->id);
    
    if (barrier == NB_THREADS ) {
        
        for(i = 0; i < NB_THREADS; i++)
            sem_post(&sem);
    
    } else {

        printf("Thread n°%ld attend\n", currThread->id);
        sem_wait(&sem);
        sleep(rand_number);
    }

    printf("Thread n°%ld a fini d'attendre\n", currThread->id);
    sem_post(&sem);

    pthread_exit(0);
}

int main() {

    sem_init(&sem, 1, 0);

    struct thread currThread[NB_THREADS];
    long resultat;
    
    printf("PID Main: % d\n", getpid());

    for (int i = 0; i < NB_THREADS; i++) {

        currThread[i].id = i;

        if (pthread_create(&pthread_id[i], NULL, (void *)f_thread, (void *) &currThread[i]) == -1)
            perror("Erreur lors de la création du thread\n");
    }
    
    for(int i = 0; i < NB_THREADS; i++){

        if (!pthread_join(pthread_id[i], (void *) &resultat))
            printf("Thread n°%d terminé\n", i);
    }

    exit(1);
}