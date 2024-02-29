package com.kavin.q1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Language;
import com.kavin.q1.service.LanguageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping("/language")
    public List<Language> getMethodName() {
        return languageService.getList();
    }

    @GetMapping("/language/{languageId}")
    public Language getId(@PathVariable("languageId") int languageId) {
        return languageService.getById(languageId);
    }

    @PostMapping("/language")
    public ResponseEntity<Language> getMethodName(@RequestBody Language entity) {
        return new ResponseEntity<>(languageService.post(entity), HttpStatus.CREATED);
    }

    @PutMapping("/language/{languageId}")
    public Language putMethodName(@PathVariable int languageId, @RequestBody Language entity) {
        return languageService.put(languageId, entity);
    }

    @DeleteMapping("/language/{languageId}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable int languageId) {
        Language deletedLanguage = languageService.del(languageId);
        if (deletedLanguage != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
