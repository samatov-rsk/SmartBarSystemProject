package com.samatov.inventoryservicebar.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rums")
public class Rum extends Beverage {
}
