package com.samatov.inventoryservicebar.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vodkas")

public class VodkaEntity extends BeverageEntity {
}
