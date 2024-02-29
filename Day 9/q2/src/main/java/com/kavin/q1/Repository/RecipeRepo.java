package com.kavin.q1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kavin.q1.model.Recipe;

public interface RecipeRepo extends JpaRepository<Recipe, Integer> {
    @Query("SELECT p FROM Recipe p WHERE p.recipeId =:recipeId")
    Recipe findRecipeId(@Param("recipeId") int recipeId);

    @Query("SELECT p FROM Recipe p WHERE p.recipeName =:recipeName")
    List<Recipe> findRecipeName(@Param("recipeName") String recipeName);
}
