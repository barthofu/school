package libs

import (
	"students/models"

	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
)

func InitDatabase() *gorm.DB {

	// init gorm sqlite database
	db, err := gorm.Open(sqlite.Open("data/students.db"), &gorm.Config{})
	if err != nil {
		panic("failed to connect database")
	}

	// migrate the schema
	db.AutoMigrate(&models.Student{})

	return db
}
