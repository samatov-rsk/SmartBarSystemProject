package com.samatov.inventoryservicebar.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rums")
public class RumEntity extends BeverageEntity {
}
