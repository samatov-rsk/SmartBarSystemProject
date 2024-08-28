package com.samatov.inventoryservicebar.dto;

import com.samatov.inventoryservicebar.entities.CocktailEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Map;

/**
 * Dto для {@link CocktailEntity}
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CocktailDTO extends BeverageDTO implements Serializable {

    @NotNull
    @NotEmpty
    Map<String, Integer> ingredients;
}
