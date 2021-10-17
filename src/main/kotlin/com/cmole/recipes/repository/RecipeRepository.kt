package com.cmole.recipes.repository

import com.cmole.recipes.controller.RequestRecipe
import com.cmole.recipes.controller.Ingredient as RequestRecipeIngredients
import com.cmole.recipes.entity.IngredientEntity
import com.cmole.recipes.entity.RecipeEntity
import com.cmole.recipes.entity.TagEntity
import com.cmole.recipes.repository.model.Recipe
import com.cmole.recipes.repository.model.RecipeTag
import com.cmole.recipes.repository.model.Ingredient
import org.jetbrains.exposed.sql.SchemaUtils
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
open class RecipesRepository {
    open fun createRepository() = SchemaUtils.create(
        Recipe,
        RecipeTag,
        Ingredient
    )

    fun getRecipes(): List<RequestRecipe> {
        val recipeCollection = RecipeEntity.all()
        return recipeCollection.map {
            val tags = TagEntity.find() {
                RecipeTag.recipe_id eq it.id.value
            }
            val ingredients = IngredientEntity.find {
                Ingredient.recipe_id eq it.id.value
            }
            RequestRecipe(
                title = it.title,
                note = it.note,
                procedure = it.procedure,
                tags = tags.mapNotNull { it.tagName },
                ingredients = ingredients.mapNotNull {
                    RequestRecipeIngredients(
                        name = it.name,
                        unit = it.unit,
                        amount = it.amount
                    )
                }
            )
        }
    }

    fun addRecipe(recipe: RequestRecipe) {
        val recipeEntity = RecipeEntity.new {
            title = recipe.title
            procedure = recipe.procedure
            note = recipe.note
        }
        recipeEntity.flush()
        recipe.ingredients?.forEach { IngredientEntity.new {
                amount = it.amount
                name = it.name
                unit = it.unit
                recipeId = recipeEntity.id.value
            }.flush()
        }
        recipe.tags?.forEach { TagEntity.new {
                tagName = it
                recipeId = recipeEntity.id.value
            }.flush()
        }
    }
}