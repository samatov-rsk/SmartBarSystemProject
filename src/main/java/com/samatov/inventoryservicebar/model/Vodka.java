package com.samatov.inventoryservicebar.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vodkas")

public class Vodka extends Beverage {
}
