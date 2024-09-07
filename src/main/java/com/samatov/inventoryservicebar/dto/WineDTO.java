package com.samatov.inventoryservicebar.dto;

import com.samatov.inventoryservicebar.entities.WineEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Dto для {@link WineEntity}
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WineDTO extends BeverageDTO implements Serializable {

    @NotEmpty(message = "Сорт винограда  не может быть пустым")
    String grapeVariety;
}
