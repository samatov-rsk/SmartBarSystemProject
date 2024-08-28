package com.samatov.inventoryservicebar.dto;

import com.samatov.inventoryservicebar.entities.VodkaEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Dto для {@link VodkaEntity}
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VodkaDTO extends BeverageDTO implements Serializable {
}
