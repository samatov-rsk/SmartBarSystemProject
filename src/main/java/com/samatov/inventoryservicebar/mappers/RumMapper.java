package com.samatov.inventoryservicebar.mappers;

import com.samatov.inventoryservicebar.dto.RumDTO;
import com.samatov.inventoryservicebar.entities.RumEntity;
import org.mapstruct.Mapper;

/**
 * Mapper для {@link RumEntity} и {@link RumDTO}
 */

@Mapper(componentModel = "spring")
public interface RumMapper {

    RumDTO toDto(RumEntity rumEntity);

    RumEntity toEntity(RumDTO rumDTO);
}
