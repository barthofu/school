package models

import (
	"gorm.io/gorm"
)

type Student struct {
	gorm.Model
	ID   int    `json:"id"`
	Name string `json:"name"`
	Age  int    `json:"age"`
}

// =====================
// CRUD functions
// =====================

func GetAllStudents(db *gorm.DB) ([]Student, error) {
	var students []Student
	result := db.Find(&students)
	return students, result.Error
}

func CreateStudent(db *gorm.DB, student Student) (Student, error) {
	result := db.Create(&student)
	return student, result.Error
}
