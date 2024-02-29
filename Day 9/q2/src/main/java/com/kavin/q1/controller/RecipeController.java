package com.kavin.q1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Recipe;
import com.kavin.q1.service.RecipeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("/recipe")
    public ResponseEntity<Recipe> postMethodName(@RequestBody Recipe param) {
        Recipe p = recipeService.post(param);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<Recipe> getMethodName(@PathVariable("recipeId") int recipeId) {
        Recipe p = recipeService.get(recipeId);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/recipe/byname")
    public ResponseEntity<List<Recipe>> getMethodName(@RequestParam("recipeName") String recipeName) {
        List<Recipe> list = recipeService.getName(recipeName);
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
