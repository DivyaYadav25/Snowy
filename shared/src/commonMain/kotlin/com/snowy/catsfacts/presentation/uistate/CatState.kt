package com.snowy.catsfacts.presentation.uistate

import com.snowy.catsfacts.domain.model.CatFacts

data class CatState(
    val catFact: String,
)

fun CatFacts.mapToUiState() = CatState(
    catFact = text
)
