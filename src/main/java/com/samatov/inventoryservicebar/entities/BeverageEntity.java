package com.samatov.inventoryservicebar.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Название класса общего для других класс называется Напитки
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BeverageEntity {
    // Название
    String name;
    //Страна производства
    String countryOfOrigin;
    //Цвет
    String color;
    //Цена
    Double price;
    //Объем в миллиметрах
    Integer volume;
    //Градус алкоголя
    Double alcoholContent;
}
