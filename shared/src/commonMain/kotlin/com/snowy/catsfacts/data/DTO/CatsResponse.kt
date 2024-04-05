package com.snowy.catsfacts.data.DTO

import com.snowy.catsfacts.domain.model.CatFacts
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatsResponse(
	@SerialName("_id")
	val id: String? = null,

	@SerialName("text")
	val text: String? = null,
)

fun CatsResponse.mapToDomainModel() = CatFacts(
	id = id.orEmpty(),
	text = if ((id.orEmpty().length /2)==0) text?.uppercase().orEmpty() else text?.lowercase().orEmpty(),
)


