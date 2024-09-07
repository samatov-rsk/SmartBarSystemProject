package com.samatov.inventoryservicebar.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BeverageDTO implements Serializable {

    @NotEmpty(message = "Название не может быть пустым")
    String name;

    @NotEmpty(message = "Страна не может быть пустым")
    String countryOfOrigin;

    @NotEmpty(message = "Цвет не может быть пустым")
    String color;

    @Positive(message = "Цена не может быть больше 0")
    Double price;

    @Positive(message = "Объём должен быть больше 0")
    Integer volume;

    @Positive(message = "Градус не может быть пустым")
    Double alcoholContent;
}
