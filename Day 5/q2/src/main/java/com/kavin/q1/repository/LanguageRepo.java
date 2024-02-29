package com.kavin.q1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavin.q1.model.Language;

public interface LanguageRepo extends JpaRepository<Language, Integer> {

}
