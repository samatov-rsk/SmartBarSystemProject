package com.samatov.inventoryservicebar.dto;


import com.samatov.inventoryservicebar.entities.JuiceEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Dto для {@link JuiceEntity}
 */

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JuiceDTO extends BeverageDTO implements Serializable {
}
