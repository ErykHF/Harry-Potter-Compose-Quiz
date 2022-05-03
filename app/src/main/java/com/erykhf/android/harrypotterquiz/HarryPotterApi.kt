package com.erykhf.android.harrypotterquiz

import com.erykhf.android.harrypotterquiz.model.Characters
import com.erykhf.android.harrypotterquiz.model.CharactersItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface HarryPotterApi {

    @GET("/characters")
    suspend fun getCharacters(): Characters
}