package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.Repository.RecipeRepo;
import com.kavin.q1.model.Recipe;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepo recipeRepo;

    public Recipe post(Recipe p) {
        return recipeRepo.save(p);
    }

    public Recipe get(int recipeId) {
        return recipeRepo.findRecipeId(recipeId);
    }

    public List<Recipe> getName(String recipeName) {
        return recipeRepo.findRecipeName(recipeName);
    }
}
