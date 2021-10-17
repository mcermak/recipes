package com.cmole.recipes.entity

import com.cmole.recipes.repository.model.RecipeTag
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID

class TagEntity(id: EntityID<Int>): Entity<Int>(id) {
    companion object : EntityClass<Int, TagEntity>(RecipeTag)

    var tagName by RecipeTag.tag
    var recipeId by RecipeTag.recipe_id
}