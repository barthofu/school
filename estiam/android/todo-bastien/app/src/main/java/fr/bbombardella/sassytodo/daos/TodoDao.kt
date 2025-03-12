package fr.bgili.todo.daos

import androidx.room.Dao
import androidx.room.Query
import fr.bgili.todo.entities.Todo

@Dao
interface TodoDao : AbstractDao<Todo> {
    @Query("SELECT * FROM todo WHERE id = :id")
    override fun find(id: Long): Todo

    @Query("SELECT * FROM todo")
    override fun findAll(): List<Todo>

    @Query("SELECT * FROM todo WHERE id IN (:ids)")
    override fun loadAllByIds(ids: IntArray): List<Todo>
}
