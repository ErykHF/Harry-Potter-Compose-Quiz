package com.erykhf.android.harrypotterquiz

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erykhf.android.HarryPotterError
import com.erykhf.android.Repository
import com.erykhf.android.harrypotterquiz.model.CharactersItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var character = mutableStateOf("")
    var nickname = mutableStateOf("")
    var hogwartsHouse = mutableStateOf("")
    var hogwartsStudent = mutableStateOf(false)
    var image = mutableStateOf("")

    init {
        getHPCharacters()
    }


    fun getHPCharacters() = viewModelScope.launch {

        when (val result = repository.loadHPCharacters()) {
            is Resource.Success -> {

                result.data?.forEach {
                    character.value = it.character
                    nickname.value = it.nickname
                    hogwartsHouse.value = it.hogwartsHouse
                    hogwartsStudent.value = it.hogwartsStudent
                    image.value = it.image
                }
            }

            is Resource.Error -> {

            }

        }
    }


}