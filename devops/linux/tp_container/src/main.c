#define _GNU_SOURCE //Doit etre appele en premie (permet d'acceder a des appels systemes non normalise: unshare ici)

#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/mount.h>
#include<unistd.h>
#include<wait.h>
#include<sched.h>


//Attention: doit etre lance en sudo/root

int main()
{
  pid_t retourFork;
  int flags;


  //0. Penser a creer tous les dossiers et copier les binaires et librairies (se fait en ligne de commande) qui seront chrooter apres (bin, tmp, media, lib, et lib64)

  //1.
  //Unshare a faire avant le fork pour un nouveau namespace pid.
  flags = CLONE_NEWPID;
  if(unshare(flags) == -1){
    printf("erreur lors de l'unshare sur le namespace pid\n");
  }
  //Pour NEWPID seuls les enfants sont dans un nouveau namespace PID - c'est pour cette raison qu'on le fait avant le fork

  //2. Votre processus se fork
  retourFork = fork();

  //3.
  //Les autres "unshare" ont lieu apres le fork pour ne pas isoler le processus pere (celui-ci peut-etre vu comme le runtime)

  //4. Le pere attend son fils et affiche son message quand celui-ci est termine: wait().
  //Traiter l'erreur aussi sur le fork.
  if(retourFork ==0){
    printf("je suis le fils\n");
    flags = CLONE_FS; 
    if(unshare(flags) == -1){
      printf("erreur lors de l'unshare sur le namespace FS\n");
    }
    flags = CLONE_NEWNS;
    if(unshare(flags) == -1){
      printf("erreur lors de l'unshare sur le namespace NEWNS\n");
    }
    flags = CLONE_NEWNET;
    if(unshare(flags) == -1){
      printf("erreur lors de l'unshare sur le namespace NEWNET\n");
    }
    flags = CLONE_NEWUTS;
    if(unshare(flags) == -1){
      printf("erreur lors de l'unshare sur le namespace NEWUTS\n");
    }


   if( mount("proc","proc","proc",0,NULL) == -1){
     printf("erreur lors du mount proc\n");
   }
   if(mount("/media","media","ext4",MS_BIND,NULL) == -1){
     printf("erreur lors du mount media\n");
   }
   if(mount("/tmp","tmp","ext4",MS_BIND,NULL) == -1){
     printf("erreur lors du mount tmp\n");
   }

   if(chroot("./") == -1){
     printf("erreur lors du chroot\n");
   }
   if(execlp("/bin/bash", "bash",(char*)NULL) == -1){
     printf("erreur lors de l'execlp\n");
     perror("error :");
   }

  } else if( retourFork == -1){
    printf("erreur dans le fork\n");
    exit(2);
  } else {
    printf("je suis le pere\n");
    wait(NULL);
    printf("je suis le père et j'ai fini d'attendre\n");
  }
  //5. Le fils:
  //	   - monter les dossiers tmp et media (type ext4 et flag MS_BIND): appel systeme mount
  //       - unshare pour creer le nouveau namespace mount 
  //       - unshare pour creer le nouveau namespace net 
  //       - unshare pour creer le nouveau namespace uts 
  //	   - Puis on monte un nouveau /proc qui sera forcement different de celui du pere car nouveau namespace fs: appel systeme mount
  //	   - on chroot: appel systeme chroot
  //	   - on lance la commande: appel systeme execlp (le fils se recouvre avec la commande (argv[1] en principe)
  
  //6. On compile, puis on teste. Essayer de tuer le processus 1 avec la commande kill. 

  return(0);
}




