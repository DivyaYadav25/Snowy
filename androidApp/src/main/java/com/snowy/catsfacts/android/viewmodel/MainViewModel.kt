package com.snowy.catsfacts.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snowy.catsfacts.presentation.uistate.CatState
import com.snowy.catsfacts.presentation.uistate.mapToUiState
import com.snowy.catsfacts.data.CatsRepositoryImpl
import com.snowy.catsfacts.domain.CatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _factsList: MutableStateFlow<List<CatState>> = MutableStateFlow(emptyList())
    val factsList: StateFlow<List<CatState>> get() = _factsList

    private val repository: CatsRepository = CatsRepositoryImpl()

    init {
        viewModelScope.launch {
            _factsList.update {
                repository.getCatsFacts().map {
                    it.mapToUiState()
                }
            }
        }
    }

}