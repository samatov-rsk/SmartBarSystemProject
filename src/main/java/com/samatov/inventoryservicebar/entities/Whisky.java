package com.samatov.inventoryservicebar.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "whiskies")
public class Whisky extends Beverage {
}
