package com.snowy.catsfacts.data

import com.snowy.catsfacts.data.DTO.mapToDomainModel
import com.snowy.catsfacts.domain.CatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class CatsRepositoryImpl: CatsRepository {
    private val apiComponent = ApiComponent()

    suspend override fun getCatsFacts() = withContext(Dispatchers.IO){
        apiComponent.getData().map {
            it.mapToDomainModel()
        }
    }
}