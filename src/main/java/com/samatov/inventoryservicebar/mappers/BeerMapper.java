package com.samatov.inventoryservicebar.mappers;

import com.samatov.inventoryservicebar.dto.BeerDTO;
import com.samatov.inventoryservicebar.entities.BeerEntity;
import org.mapstruct.Mapper;

/**
 * Mapper для {@link BeerEntity} и {@link BeerDTO}
 */

@Mapper(componentModel = "spring")
public interface BeerMapper {

    BeerDTO toDto(BeerEntity beerEntity);

    BeerEntity toEntity(BeerDTO beerDTO);
}
