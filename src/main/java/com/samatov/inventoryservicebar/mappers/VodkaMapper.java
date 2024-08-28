package com.samatov.inventoryservicebar.mappers;

import com.samatov.inventoryservicebar.dto.VodkaDTO;
import com.samatov.inventoryservicebar.entities.VodkaEntity;
import org.mapstruct.Mapper;

/**
 * Mapper для {@link VodkaEntity} и {@link VodkaDTO}
 */

@Mapper(componentModel = "spring")
public interface VodkaMapper {

    VodkaDTO toDto(VodkaEntity vodkaEntity);

    VodkaEntity toEntity(VodkaDTO vodkaDTO);
}
