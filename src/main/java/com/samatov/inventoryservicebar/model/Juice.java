package com.samatov.inventoryservicebar.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "juices")
public class Juice extends Beverage{
}
