package fr.bgili.todo.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import fr.bgili.todo.entities.BaseEntity

abstract class BaseDao<T : BaseEntity> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(entity: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(entities: List<T>): LongArray

    @Update
    abstract fun update(entity: T)

    @Update
    abstract fun update(entities: List<T>)

    @Delete
    abstract fun delete(entity: T)

    @Delete
    abstract fun delete(entities: List<T>)

}