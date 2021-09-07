package com.paradigm_shifters.tacocloud.model;

import lombok.Data;         // lombok library automatically sets the getters and setters at runtime
import lombok.RequiredArgsConstructor;

@Data                       // Automatically generate essential Java methods at runtime
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}