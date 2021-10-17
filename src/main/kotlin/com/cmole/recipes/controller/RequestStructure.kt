package com.cmole.recipes.controller

data class RequestRecipe(
    val title: String,
    val procedure: String,
    val note: String,
    val ingredients: List<Ingredient>? = null,
    val tags: List<String>? = null
)

data class GetRecipeSimple(
    val id: Int,
    val title: String,
    val tags: List<String>? = null,
    val ingredients: List<Ingredient>? = null
)

data class Ingredient (
    val name: String,
    val amount: Float,
    val unit: String
)
