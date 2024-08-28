package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.CocktailNotFoundException;
import com.samatov.inventoryservicebar.dto.CocktailDTO;
import com.samatov.inventoryservicebar.entities.CocktailEntity;
import com.samatov.inventoryservicebar.mappers.CocktailMapper;
import com.samatov.inventoryservicebar.repositories.CocktailRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CocktailService {

    CocktailRepository cocktailRepository;

    CocktailMapper cocktailMapper;

    public List<CocktailDTO> getAllCocktails() {
        List<CocktailEntity> cocktails = cocktailRepository.findAll();
        log.info("Получены все позиции коктейлей из базы данных");
        if (cocktails.isEmpty()) {
            throw new CocktailNotFoundException("Позиции коктейлей не найдены в базе данных");
        }
        return cocktails.stream().map(cocktailMapper::toDto).collect(Collectors.toList());
    }

    public void saveCocktail(CocktailDTO cocktailDTO) {
        CocktailEntity cocktail = cocktailMapper.toEntity(cocktailDTO);
        log.info("Добавление коктейля в базу данных");
        cocktailRepository.save(cocktail);
    }

    public void deleteCocktailById(String id) {
        log.info("Удаление коктейля из база данных");
        if (!cocktailRepository.existsById(id)) {
            throw new CocktailNotFoundException("Коктейль с данным идендификатором не найдено");
        }
        cocktailRepository.deleteById(id);
    }

    public void deleteAllCocktails() {
        log.info("Удаление всех позиций коктейля из база данных");
        cocktailRepository.deleteAll();
    }

    public void updateCocktail(String id, CocktailDTO cocktailDTO) {
        Optional<CocktailEntity> existingCocktail = cocktailRepository.findById(id);
        if (existingCocktail.isPresent()) {
            CocktailEntity updatedCocktail = existingCocktail.get();
            updatedCocktail.setName(cocktailDTO.getName());
            updatedCocktail.setColor(cocktailDTO.getColor());
            updatedCocktail.setPrice(cocktailDTO.getPrice());
            updatedCocktail.setVolume(cocktailDTO.getVolume());
            updatedCocktail.setAlcoholContent(cocktailDTO.getAlcoholContent());
            updatedCocktail.setIngredients(cocktailDTO.getIngredients());
            log.info("Коктейль изменился в базе данных");
            cocktailRepository.save(updatedCocktail);
        } else {
            throw new CocktailNotFoundException("Коктейль с данным идендификатором не найдено");
        }
    }

    public CocktailDTO findCocktailById(String id) {
        return cocktailRepository.findById(id)
                .map(cocktailMapper::toDto)
                .orElseThrow(() -> new CocktailNotFoundException("Коктейль с данным идендификатором не найдено"));
    }
}
