package com.paradigm_shifters.tacocloud.model;

import lombok.Data;                             // lombok library automatically sets the getters and setters at runtime

/*
  @Data generates getters and setters for all fields.
  toString method, hashcode, equals implementation, generates setters
  for all non-final fields, constructor.
  Combines @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
*/
@Data
//@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}