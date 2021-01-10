package com.devdossantos.myapplication.cartao.repository

import com.devdossantos.myapplication.cartao.entity.CartaoEntity
import com.devdossantos.myapplication.cartao.dao.CartaoDao

class CartaoRepository(private val cartaoDao: CartaoDao) {

    suspend fun addCartao(cartao: CartaoEntity) = cartaoDao.addCartao(cartao)
    suspend fun count() = cartaoDao.count()
}