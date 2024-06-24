package com.example.jetweatherapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetweatherapp.model.Favorite
import com.example.jetweatherapp.repository.WeatherDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: WeatherDbRepository): ViewModel(){
    private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
    val favList = _favList.asStateFlow()
    init {
        viewModelScope.launch {
            repository.getFavorites().distinctUntilChanged().collect{
                if(it.isEmpty()){
                    _favList.value = emptyList()
                }else{
                    _favList.value = it
                }
            }
        }
    }
    fun insertFavorite(favorite: Favorite) = viewModelScope.launch {
        repository.insertFavorite(favorite)
    }
    fun updateFavorite(favorite: Favorite) = viewModelScope.launch {
        repository.updateFavorite(favorite)
    }
    fun deleteFavorite(favorite: Favorite) = viewModelScope.launch {
        repository.deleteFavorite(favorite)
    }
    fun deleteAllFavorites() = viewModelScope.launch {
        repository.deleteAllFavorites()
    }

}
