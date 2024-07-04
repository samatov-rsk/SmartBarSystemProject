package com.samatov.inventoryservicebar.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "cocktails")
public class Cocktail extends Beverage {

    private Map<String, Integer> ingredients;
}
