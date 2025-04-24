package com.ilya.therickandmorty.repository

import com.ilya.therickandmorty.model.core.RetrofitClient

class CharacterRepository {
    suspend fun getCharacter() = RetrofitClient.characterService.getCharacter()
}