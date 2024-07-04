package com.samatov.inventoryservicebar.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//Название класса общего для других класс называется Напитки
public abstract class Beverage {
    // Название
   private String name;
   //Страна производства
   private String countryOfOrigin;
   //Цвет
   private String color;
   //Цена
   private Double price;
   //Объем в миллиметрах
   private Integer volume;
   //Градус алкоголя
   private Double acoholContent;

}
