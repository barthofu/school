package main

import (
	"fmt"
	"os"
	"strings"
	"time"
)

func onError(err error) {
	if err != nil {
		os.Exit(-1)
	}
}

func genericPrint(info string) {
	fmt.Printf("Entrez votre %s : ", info)
}

func enterString(ref *string) {
	_, err := fmt.Scanln(ref)
	onError(err)
}

func enterNumber(ref any) {
	_, err := fmt.Scanf("%d\n", ref)
	onError(err)
}

func main() {
	fmt.Println("Hello, World!")

	var nom, prenom string
	var age uint8
	var annee uint16

	genericPrint("nom")
	enterString(&nom)

	genericPrint("prénom")
	enterString(&prenom)

	genericPrint("âge")
	enterNumber(&age)

	genericPrint("année de naissance")
	enterNumber(&annee)

	fmt.Printf("Tu t'appelles %s %s et tu as %d an", strings.ToUpper(nom), prenom, age)
	if age > 1 {
		fmt.Print("s")
	}

	fmt.Printf("\nTon âge théorique est %d", time.Now().Year()-int(annee))

	fmt.Printf("\nAujourd'hui nous le : %s", time.Now().Format("02/01/2006"))
}
