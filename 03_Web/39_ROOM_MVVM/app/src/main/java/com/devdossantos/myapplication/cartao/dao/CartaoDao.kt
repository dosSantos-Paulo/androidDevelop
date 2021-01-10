package com.devdossantos.myapplication.cartao.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devdossantos.myapplication.cartao.entity.CartaoEntity

@Dao
interface CartaoDao {

    @Insert
    suspend fun addCartao(carta: CartaoEntity)

    @Query("SELECT COUNT(*) FROM Cartao")
    suspend fun count(): Int
}