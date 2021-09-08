package com.paradigm_shifters.tacocloud.dao;

import com.paradigm_shifters.tacocloud.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
  The @Repository includes @Controller and @Component declaring that this
  class should be automatically discovered by Spring component scanning
  and instantiated as a bean in the Spring application context. When
  Spring creates the class bean, it injects it with JdbcTemplate via
  the @Autowired annotated construction. The constructor assigns
  JdbcTemplate to an instance variable that will be used in other
  methods to query and insert into the database.
 */
@Repository
public class JdbcIngredientRepository
        implements IngredientRepository {

    private JdbcTemplate jdbc;

    @Autowired             // Autowire one primary constructor, not both otherwise set one @Autowired as true and the other as false
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient, id);
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
            throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}