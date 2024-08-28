package com.samatov.inventoryservicebar.mappers;

import com.samatov.inventoryservicebar.dto.WhiskyDTO;
import com.samatov.inventoryservicebar.entities.WhiskyEntity;
import org.mapstruct.Mapper;

/**
 * Mapper для {@link WhiskyEntity} и {@link WhiskyDTO}
 */

@Mapper(componentModel = "spring")
public interface WhiskyMapper {

    WhiskyDTO toDto(WhiskyEntity whiskyEntity);

    WhiskyEntity toEntity(WhiskyDTO whiskyDTO);
}
