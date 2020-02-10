package com.benrostudios.xpenso.data.repo

import androidx.lifecycle.LiveData
import com.benrostudios.xpenso.data.db.entity.ExpensesEntry

interface ExpensesRepo {
    suspend fun getExpensesData(): LiveData<ExpensesEntry>
}