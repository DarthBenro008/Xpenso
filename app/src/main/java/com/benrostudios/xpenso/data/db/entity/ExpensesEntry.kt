package com.benrostudios.xpenso.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "expenses_table")
data class ExpensesEntry(
    val person: String,
    val amount: Double,
    val descp: String,
    val category: String ,
    val modeOfPayment: String
){

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}