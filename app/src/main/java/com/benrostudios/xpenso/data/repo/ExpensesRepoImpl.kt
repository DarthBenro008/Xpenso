package com.benrostudios.xpenso.data.repo

import androidx.lifecycle.LiveData
import com.benrostudios.xpenso.data.db.ExpensesDAO
import com.benrostudios.xpenso.data.db.entity.ExpensesEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ExpensesRepoImpl(private val expensesDAO: ExpensesDAO) : ExpensesRepo {
    override suspend fun getExpensesData(): LiveData<ExpensesEntry> {
        return withContext(Dispatchers.IO){
            return@withContext expensesDAO.getExpensesData()
        }
    }

     fun insertExpense(newExpense: ExpensesEntry){
        GlobalScope.launch(Dispatchers.IO) {
                expensesDAO.upsert(newExpense)
        }
    }
}