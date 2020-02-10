package com.benrostudios.xpenso.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.benrostudios.xpenso.data.db.entity.ExpensesEntry

@Database(
    entities = [ExpensesEntry::class],
    version = 1
)

abstract class ExpensesDatabase: RoomDatabase() {
    abstract fun expensesDAO(): ExpensesDAO

companion object{
    @Volatile private var instance: ExpensesDatabase ?=  null
    private var LOCK = Any()

    operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
        instance ?: buildDatabase(context).also { instance = it }
    }
    private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,ExpensesDatabase::class.java,"expenses.db").build()
}

}