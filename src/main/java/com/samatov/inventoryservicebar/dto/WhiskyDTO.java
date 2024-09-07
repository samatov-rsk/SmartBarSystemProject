package com.samatov.inventoryservicebar.dto;

import com.samatov.inventoryservicebar.entities.WhiskyEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Dto для {@link WhiskyEntity}
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WhiskyDTO extends BeverageDTO implements Serializable {
}
