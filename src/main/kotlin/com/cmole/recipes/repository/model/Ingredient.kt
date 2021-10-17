package com.cmole.recipes.repository.model

import org.jetbrains.exposed.dao.IntIdTable

object Ingredient : IntIdTable() {
    val recipe_id = integer("recipe_id").references(Recipe.id)
    val name = varchar("name", 255).primaryKey()
    val unit = varchar("unit", 16)
    val amount = float("amount")
    init {
        index(isUnique = true, recipe_id, name)
    }
}