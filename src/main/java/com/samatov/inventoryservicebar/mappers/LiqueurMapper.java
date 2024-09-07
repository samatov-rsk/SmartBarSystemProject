package com.samatov.inventoryservicebar.mappers;

import com.samatov.inventoryservicebar.dto.LiqueurDTO;
import com.samatov.inventoryservicebar.entities.LiqueurEntity;
import org.mapstruct.Mapper;

/**
 * Mapper для {@link LiqueurEntity} и {@link LiqueurDTO}
 */

@Mapper(componentModel = "spring")
public interface LiqueurMapper {

    LiqueurDTO toDto(LiqueurEntity liqueurEntity);

    LiqueurEntity toEntity(LiqueurDTO liqueurDTO);
}
