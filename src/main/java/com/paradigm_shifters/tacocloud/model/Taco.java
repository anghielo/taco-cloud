package com.paradigm_shifters.tacocloud.model;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;                         // lombok library automatically sets the getters and setters at runtime

/*
  @Data generates getters and setters for all fields.
  toString method, hashcode, equals implementation, generates setters
  for all non-final fields, constructor.
  Combines @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
*/
@Data
public class Taco {

    @NotNull        // Validation rule requiring the input to not be null
    @Size(min=5, message="Name must be at least 5 characters long") // Validation input requiring a min size
    private String name;
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;

    private Long id;
    private Date createAt;
}