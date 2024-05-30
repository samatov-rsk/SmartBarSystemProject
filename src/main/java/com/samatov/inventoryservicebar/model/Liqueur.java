package com.samatov.inventoryservicebar.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "liqueurs")
public class Liqueur extends Beverage {
}
