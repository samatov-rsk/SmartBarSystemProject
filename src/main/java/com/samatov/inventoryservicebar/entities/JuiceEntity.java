package com.samatov.inventoryservicebar.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "juices")
public class JuiceEntity extends BeverageEntity {
}
