package com.cmole.recipes.entity

import com.cmole.recipes.repository.model.Recipe
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID

class RecipeEntity(id: EntityID<Int>): Entity<Int>(id) {
    companion object : EntityClass<Int, RecipeEntity>(Recipe)

    var title by Recipe.title
    var procedure by Recipe.procedure
    var note by Recipe.note
}