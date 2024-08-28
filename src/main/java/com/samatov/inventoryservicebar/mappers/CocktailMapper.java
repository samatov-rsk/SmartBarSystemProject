package com.samatov.inventoryservicebar.mappers;

import com.samatov.inventoryservicebar.dto.CocktailDTO;
import com.samatov.inventoryservicebar.entities.CocktailEntity;
import org.mapstruct.Mapper;

/**
 * Mapper для {@link CocktailEntity} и {@link CocktailDTO}
 */

@Mapper(componentModel = "spring")
public interface CocktailMapper {

    CocktailDTO toDto(CocktailEntity cocktailEntity);

    CocktailEntity toEntity(CocktailDTO cocktailDTO);
}
