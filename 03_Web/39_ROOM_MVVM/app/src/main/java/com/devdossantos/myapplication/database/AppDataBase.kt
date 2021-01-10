package com.devdossantos.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devdossantos.myapplication.cartao.entity.CartaoEntity
import com.devdossantos.myapplication.cartao.dao.CartaoDao

@Database(
    entities = [CartaoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase: RoomDatabase() {

    abstract fun cartaoDao(): CartaoDao

    companion object{
        fun getDatabase(context: Context): AppDataBase {
            val instancia = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "pagbem"
            ).build()

            return instancia
        }
    }
}