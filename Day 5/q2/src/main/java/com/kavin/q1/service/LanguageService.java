package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Language;
import com.kavin.q1.repository.LanguageRepo;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepo languageRepo;

    public Language post(Language p) {
        return languageRepo.save(p);
    }

    public Language put(int id, Language p) {
        Language newProduct = languageRepo.findById(id).orElse(null);
        return languageRepo.save(newProduct);
    }

    public Language del(int id) {
        Language p = languageRepo.findById(id).orElse(null);
        if (p != null) {
            languageRepo.deleteById(id);
            return p;
        }
        return null;
    }

    public List<Language> getList() {
        return languageRepo.findAll();
    }

    public Language getById(int id) {
        return languageRepo.findById(id).orElse(null);
    }
}
