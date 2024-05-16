package fr.bgili.todo.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import fr.bgili.todo.entities.AbstractEntity

@Dao
interface AbstractDao<T : AbstractEntity> {
    fun find(id: Long): T

    fun findAll(): List<T>

    fun loadAllByIds(ids: IntArray): List<T>

    @Insert
    fun add(vararg data: T)

    @Update
    fun update(data: T)

    @Delete
    fun delete(data: T)
}