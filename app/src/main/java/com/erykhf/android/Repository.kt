package com.erykhf.android

import com.erykhf.android.harrypotterquiz.HarryPotterApi
import com.erykhf.android.harrypotterquiz.Resource
import com.erykhf.android.harrypotterquiz.model.Characters
import com.erykhf.android.harrypotterquiz.model.CharactersItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: HarryPotterApi) {

    suspend fun loadHPCharacters(): Resource<Characters> {

        val response = api.getCharacters()

        val result = try {
            response
        } catch (cause: Throwable) {
            throw HarryPotterError("Error", cause)
        }

        return Resource.Success(result)
    }


}


class HarryPotterError(message: String, cause: Throwable?) : Throwable(message, cause)
