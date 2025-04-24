package com.ilya.therickandmorty.model.service

import com.ilya.therickandmorty.model.model.CharacterResponse
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getCharacter() : CharacterResponse?
}