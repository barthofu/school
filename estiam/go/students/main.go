package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
	"students/models"
	"students/utils"
)

// add a student to the list
func addStudent(students *[]models.Student) {
	var student models.Student

	fmt.Print("Entrez le nom de l'étudiant: ")
	// use of bufio so we can read the whole line (with spaces)
	reader := bufio.NewReader(os.Stdin)
	line, err := reader.ReadString('\n')
	if err != nil {
		fmt.Println("Erreur de lecture:", err)
		return
	}
	student.Name = strings.TrimSpace(line)

	for {
		fmt.Print("Entrez l'âge de l'étudiant: ")
		_, err := fmt.Scanf("%d\n", &student.Age)
		println(student.Age, err == nil)
		if err == nil && student.Age > 0 {
			break
		}
		fmt.Println("L'âge doit être un entier > 0!")
	}

	// incremental id generation
	student.ID = len(*students) + 1

	*students = append(*students, student)
	fmt.Println("Étudiant ajouté avec succès!")
}

// displays the list of students
func displayStudents(students []models.Student) {
	fmt.Println("Liste des étudiants:")
	for _, student := range students {
		fmt.Printf("ID: %d, Nom: %s, Âge: %d\n", student.ID, student.Name, student.Age)
	}
}

// calculates the average age of the students
func calculateAverageAge(students []models.Student) float64 {
	var totalAge int
	for _, student := range students {
		totalAge += student.Age
	}

	return float64(totalAge) / float64(len(students))
}

func main() {

	// ====================
	// students
	// ====================

	var students []models.Student
	loadErr := utils.LoadFromFile("students.json", &students)
	if loadErr != nil {
		fmt.Println("Erreur lors du chargement du fichier:", loadErr)
		os.Exit(1)
	}

	for {
		fmt.Print("Voulez-vous ajouter un nouvel étudiant? (O/N): ")
		var choice string
		fmt.Scanln(&choice)

		if choice != "O" && choice != "o" {
			break
		}

		addStudent(&students)
	}

	displayStudents(students)

	// save students to JSON file
	saveErr := utils.SaveToFile(students, "students.json")
	if saveErr != nil {
		fmt.Println("Erreur lors de l'enregistrement du fichier:", saveErr)
	} else {
		fmt.Println("Liste des étudiants enregistrée dans students.json.")
	}

	// ====================
	// average age
	// ====================

	averageAge := calculateAverageAge(students)
	fmt.Printf("L'âge moyen des étudiants est de %.2f ans.\n", averageAge)

	// save average age to JSON file
	saveErr = utils.SaveToFile(averageAge, "average_age.json")
	if saveErr != nil {
		fmt.Println("Erreur lors de l'enregistrement du fichier:", saveErr)
	} else {
		fmt.Println("Âge moyen enregistré dans average_age.json.")
	}
}