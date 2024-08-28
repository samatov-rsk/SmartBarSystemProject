package com.samatov.inventoryservicebar.mappers;

import com.samatov.inventoryservicebar.dto.JuiceDTO;
import com.samatov.inventoryservicebar.entities.JuiceEntity;
import org.mapstruct.Mapper;

/**
 * Mapper для {@link JuiceEntity} и {@link JuiceDTO}
 */

@Mapper(componentModel = "spring")
public interface JuiceMapper {

    JuiceDTO toDto(JuiceEntity juiceEntity);

    JuiceEntity toEntity(JuiceDTO juiceDTO);
}
