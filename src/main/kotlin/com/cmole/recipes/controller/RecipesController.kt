package com.cmole.recipes.controller
import com.cmole.recipes.repository.RecipesRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RecipesController(recipesRepository: RecipesRepository) {
    private val recipesRepository = recipesRepository

    init { recipesRepository.createRepository() }

    @GetMapping("/recipes")
    fun list(): List<RequestRecipe> = recipesRepository.getRecipes()

    @PostMapping("/recipes")
    fun add(@RequestBody recipe: RequestRecipe) = recipesRepository.addRecipe(recipe)
}