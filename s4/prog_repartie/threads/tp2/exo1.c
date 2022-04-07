#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <pthread.h>
#include <string.h>
#include <sys/types.h>

#define NBR_THREADS 10

long solde = 0;
long *p_solde = &solde;

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_t pthread_id[NB_THREADS];

struct compte {
    long id;
    long somme;
};

void *f_thread (void *args_thread_r) {

    struct compte *currCompte = (struct compte *)args_thread_r;

    printf("=== Nouvelle transaction ===\nID: %ld\nSomme: %ld\n", currCompte->id, currCompte->somme);
    
    for (int i = 0; i < 100000; i++) {

    	pthread_mutex_lock(&mutex);
        *p_solde = *p_solde + currCompte->somme;
        pthread_mutex_unlock(&mutex) ;
    }

    pthread_exit(0);
}

int main() {
    
    struct compte currCompte[NB_THREADS];
    long resultat;
    int i;

    printf("Banque ID: % d\n", getpid());

    for (i = 0; i < NB_THREADS; i++) {

        currCompte[i].somme = 10;
        currCompte[i].id = i;

        if (pthread_create(&pthread_id[i], NULL, (void *)f_thread, (void *) &currCompte[i]) == -1)
            perror("Erreur lors de la création du thread\n");        
    }
    
    for (int i = 0; i < NB_THREADS; i++){

        if (!pthread_join(pthread_id[i], (void *) &resultat))
            printf("Transaction terminée : %d\n", i);

    }

    printf("========\nNouveau solde : %ld€\nPartage stoplé\n", *p_solde);

    exit(1);
}