package com.samatov.inventoryservicebar.dto;

import com.samatov.inventoryservicebar.entities.LiqueurEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Dto для {@link LiqueurEntity}
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LiqueurDTO extends BeverageDTO implements Serializable {
}
