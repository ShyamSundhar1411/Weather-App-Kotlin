package com.example.jetweatherapp.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetweatherapp.model.MeasureUnit
import com.example.jetweatherapp.repository.WeatherDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val repository: WeatherDbRepository): ViewModel(){
    private val _Measure_unitList = MutableStateFlow<List<MeasureUnit>>(emptyList())
    val unitList = _Measure_unitList.asStateFlow()
    init {
        viewModelScope.launch {
            repository.getMeasureUnits().distinctUntilChanged().collect{
                if(it.isEmpty()){
                    _Measure_unitList.value = emptyList()
                }else{
                    _Measure_unitList.value = it
                }
            }
        }
    }
    fun insertUnit(measureUnit: MeasureUnit) = viewModelScope.launch {
        repository.insertMeasureUnit(measureUnit)
    }
    fun updateUnit(measureUnit: MeasureUnit) = viewModelScope.launch {
        repository.updateMeasureUnit(measureUnit)
    }
    fun deleteUnit(measureUnit: MeasureUnit) = viewModelScope.launch {
        repository.deleteMeasureUnit(measureUnit)
    }
    fun deleteAllUnits() = viewModelScope.launch {
        repository.deleteAllMeasureUnits()
    }

}
