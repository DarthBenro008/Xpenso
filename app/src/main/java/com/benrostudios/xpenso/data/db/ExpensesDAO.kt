package com.benrostudios.xpenso.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.benrostudios.xpenso.data.db.entity.ExpensesEntry

@Dao
interface ExpensesDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun upsert(expensesEntry: ExpensesEntry)

    @Query("select * from expenses_table")
    fun getExpensesData(): LiveData<ExpensesEntry>


}