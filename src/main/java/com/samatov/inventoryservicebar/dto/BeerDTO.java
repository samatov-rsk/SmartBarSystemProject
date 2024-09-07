package com.samatov.inventoryservicebar.dto;

import com.samatov.inventoryservicebar.entities.BeerEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Dto для {@link BeerEntity}
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BeerDTO extends BeverageDTO implements Serializable {

    @NotNull
    Boolean isFiltered;
}
