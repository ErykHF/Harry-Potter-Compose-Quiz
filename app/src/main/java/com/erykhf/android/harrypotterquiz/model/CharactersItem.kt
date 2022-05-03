package com.erykhf.android.harrypotterquiz.model

data class CharactersItem(
    val character: String = "",
    val child: List<Any> = listOf(),
    val hogwartsHouse: String = "",
    val hogwartsStudent: Boolean = false,
    val id: Int = 0,
    val image: String = "",
    val interpretedBy: String = "",
    val nickname: String = ""
)