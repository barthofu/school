package fr.bgili.todo.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Todo(
    @PrimaryKey override val id: Long?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "urgency") val urgency: String
) : AbstractEntity(id), Serializable
