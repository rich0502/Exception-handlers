package com.ehd.exceptionhandlers.entities;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Customer {
    @NotNull(message = "id shouldn't be null")
    @NotEmpty(message = "id shouldn't be Empty")
    private String id;
    @NotBlank(message = "name shouldn't be null or Empty")
    private String name;
    // @Pattern(regexp = [A-Za-z0-9])
    private String type;
    @Min(value = 499, message = "price shouldn't be less than 499")
    @Max(value = 100000, message = "price shouldn't be exceed more than 100000")
    private double price;
    private Double quantity;
}
