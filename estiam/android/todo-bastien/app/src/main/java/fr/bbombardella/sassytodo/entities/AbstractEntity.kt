package fr.bgili.todo.entities

import androidx.room.PrimaryKey

abstract class AbstractEntity(
    @PrimaryKey open val id: Long?
)