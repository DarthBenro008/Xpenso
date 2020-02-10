package com.benrostudios.xpenso

import android.app.Application
import com.benrostudios.xpenso.data.db.ExpensesDatabase
import com.benrostudios.xpenso.data.repo.ExpensesRepo
import com.benrostudios.xpenso.data.repo.ExpensesRepoImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class XpensoApplication: Application(), KodeinAware{
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@XpensoApplication))

        bind() from singleton { ExpensesDatabase(instance())}
        bind() from singleton { instance<ExpensesDatabase>().expensesDAO()}
        bind<ExpensesRepo>() with singleton { ExpensesRepoImpl(instance()) }
    }
}

