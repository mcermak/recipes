package com.cmole.recipes.repository.model

import org.jetbrains.exposed.dao.IntIdTable

object RecipeTag : IntIdTable() {
    val recipe_id = integer("recipe_id").references(Recipe.id)
    val tag = varchar("tag", 64)
    init {
        index(isUnique = true, recipe_id, tag)
    }
}