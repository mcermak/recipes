package com.cmole.recipes.entity

import com.cmole.recipes.repository.model.Ingredient
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID

class IngredientEntity(id: EntityID<Int>): Entity<Int>(id) {
    companion object : EntityClass<Int, IngredientEntity>(Ingredient)
    var name by Ingredient.name
    var unit by Ingredient.unit
    var amount by Ingredient.amount
    var recipeId by Ingredient.recipe_id
}