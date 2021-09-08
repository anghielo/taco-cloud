package com.paradigm_shifters.tacocloud.dao;

import com.paradigm_shifters.tacocloud.model.Ingredient;

// Implementation of this interface repository will use the JdbcTemplate to query database.
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}