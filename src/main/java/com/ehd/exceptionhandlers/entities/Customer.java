package com.ehd.exceptionhandlers.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String type;
    private Double quantity;
}
