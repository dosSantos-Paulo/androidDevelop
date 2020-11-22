package com.example.webservice.api.model

import com.example.webservice.api.model.CharacterModel
import com.example.webservice.api.model.PageInfoModel

data class ApiResponseModel<T> (
    val info: PageInfoModel,
    val results: List<T>
)
