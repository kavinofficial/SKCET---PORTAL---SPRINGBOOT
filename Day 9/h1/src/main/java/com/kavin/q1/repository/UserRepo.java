package com.kavin.q1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kavin.q1.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.userId =:userId")
    User findRecipeId(@Param("userId") int userId);

    @Query("SELECT p FROM User p WHERE p.userName =:userName")
    List<User> findRecipeName(@Param("userName") String userName);
}
