#define _GNU_SOURCE // Doit etre appele en premier (permet d'acceder a des appels systemes non normalise: unshare ici)

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/mount.h>
#include <unistd.h>
#include <wait.h>
#include <sched.h>

// Attention: doit etre lance en sudo/root

int main() {

	pid_t forkReturn;

	// 1. Unshare a faire avant le fork pour un nouveau namespace pid.
	// Pour NEWPID seuls les enfants sont dans un nouveau namespace PID - c'est pour cette raison qu'on le fait avant le fork
	if (unshare(CLONE_NEWPID) == 1) perror("[1] error during unshare");

	// 2. Votre processus se fork
	forkReturn = fork();

	// 3. Les autres "unshare" ont lieu apres le fork pour ne pas isoler le processus pere (celui-ci peut-etre vu comme le runtime)
	
	if (
		unshare(CLONE_FS) == 1
		|| unshare(CLONE_NEWNS) == 1
		|| unshare(CLONE_NEWNET) == 1
		|| unshare(CLONE_NEWUTS) == 1    
		) {
			perror("[3] error during unshare");
		}

	// 4. Le pere attend son fils et affiche son message quand celui-ci est termine: wait().
	// Traiter l'erreur aussi sur le fork.
	if (forkReturn != 0) {

		// father
		printf("[4] forked as %d\n", forkReturn);

		if ((forkReturn = wait(&forkReturn)) == -1) {
      		perror("[4] wait\n");
		} else {
			printf("[4] %d (son) died : %d (father) terminating\n", forkReturn, getpid());
			exit(0);
		}
	}

	// 5. Le fils:
	//	   - monter les dossiers tmp et media (type ext4 et flag MS_BIND): appel systeme mount
	//        - unshare pour creer le nouveau namespace mount
	//        - unshare pour creer le nouveau namespace net
	//        - unshare pour creer le nouveau namespace uts
	//	   - Puis on monte un nouveau /proc qui sera forcement different de celui du pere car nouveau namespace fs: appel systeme mount
	//	   - on chroot: appel systeme chroot
	//	   - on lance la commande: appel systeme execlp (le fils se recouvre avec la commande (argv[1] en principe)
	
	if (mount("/tmp", "tmp", "ext4", MS_BIND, NULL) == 1) perror("[5] mount error '/tmp'");
	if (mount("/media", "media", "ext4", MS_BIND, NULL) == 1) perror("[5] mount error '/media'");

	if (mount("proc", "proc", "proc", 0, NULL) == 1) perror("[5] mount error '/proc'");

	if (chroot("./") == 1) perror("[5] chroot error");
	if (execlp("/bin/bash", "bash", NULL)) perror("[5] execlp error");

	// 6. On compile, puis on teste. Essayer de tuer le processus 1 avec la commande kill.
	return (0);
}