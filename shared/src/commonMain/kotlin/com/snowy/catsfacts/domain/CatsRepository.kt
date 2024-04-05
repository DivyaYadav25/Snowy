package com.snowy.catsfacts.domain

import com.snowy.catsfacts.domain.model.CatFacts

interface CatsRepository {
   suspend fun getCatsFacts(): List<CatFacts>
}