package com.samatov.inventoryservicebar.mappers;

import com.samatov.inventoryservicebar.dto.WineDTO;
import com.samatov.inventoryservicebar.entities.WineEntity;
import org.mapstruct.Mapper;

/**
 * Mapper для {@link WineEntity} и {@link WineDTO}
 */

@Mapper(componentModel = "spring")
public interface WineMapper {

    WineDTO toDto(WineEntity wineEntity);

    WineEntity toEntity(WineDTO wineDTO);
}
