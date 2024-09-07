package com.samatov.inventoryservicebar.dto;

import com.samatov.inventoryservicebar.entities.RumEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Dto для {@link RumEntity}
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RumDTO extends BeverageDTO implements Serializable {
}
