#include <pthread.h>
#include <errno.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <math.h>

#define NBR_THREADS 2

long j = 0;
float u = 2;

pthread_mutex_t mutex_i = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t mutex_u = PTHREAD_MUTEX_INITIALIZER;
pthread_t pthread_id[NB_THREADS];

struct thread {
    long id;
};

void *f_thread(void *args_thread_r) {

    struct thread *currStruct = (struct thread *) args_thread_r;

    for (int j = 0; j < 10000; j++) {
        
    	pthread_mutex_lock(&mutex_i);
        j++;
        
        float nominateur = 4*j*j;
        float denominateur = 4*j*j-1;

        pthread_mutex_lock(&mutex_u);
        pthread_mutex_unlock(&mutex_i);

        u = u * nominateur/denominateur;

        pthread_mutex_unlock(&mutex_u);
        printf("======\nID: %ld\nu: %f\ni: %ld\n", currStruct->id, u, j);
    }

    pthread_exit(0);
}

int main() {

    struct thread currStruct[NB_THREADS];
    long resultat;
    int j;

    printf("ID: % d\n", getpid());
    
    for (j = 0; j < NB_THREADS; j++) {
        
        currStruct[j].id = j;

        if (pthread_create(&pthread_id[j], NULL, (void *)f_thread, (void *) &currStruct[j]) == -1)
            perror("Erreur lors de la création du thread\n");
    }
    
    for (j = 0; j < NB_THREADS; j++){

        if (!pthread_join(pthread_id[j], (void *) &resultat))
            printf("Transaction terminée : %d\n", j);
    }

    printf("U = %f", u);
    
    exit(1);
}