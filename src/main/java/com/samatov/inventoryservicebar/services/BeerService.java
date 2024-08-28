/**
 * Аннотация @Service говорит о том что Spring будет управлять жизненым циклом этого класса
 * это значит что Spring будет создавать экземпляр этого класса и по мере необходимости уничтожать
 * а также предоставлять зависимости которые требуются этому классу через механизм DI
 * <p>
 * Аннотация @Autowired говорит о том что Spring автоматический будет инжектить
 * это значит что Spring будет автоматический предоставлять экземпляры необходимых класснов или же интерфейсов
 * которые требуются для работы данного компонента
 * <p>
 * Аннотация @Override говорит о том что методы буду переопределены это значит что будет другая реализация методов
 */

package com.samatov.inventoryservicebar.services;

import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.BeerNotFoundException;
import com.samatov.inventoryservicebar.dto.BeerDTO;
import com.samatov.inventoryservicebar.entities.BeerEntity;
import com.samatov.inventoryservicebar.mappers.BeerMapper;
import com.samatov.inventoryservicebar.repositories.BeerRepository;
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
public class BeerService {

    BeerRepository beerRepository;

    BeerMapper beerMapper;

    // Метод для получения всего пива
    public List<BeerDTO> getAllBeers() {
        List<BeerEntity> beers = beerRepository.findAll();
        log.info("Получены все позиции пива из базы данных");
        if (beers.isEmpty()) {
            throw new BeerNotFoundException("Позиции пива не найдены в базе данных");
        }
        return beers.stream().map(beerMapper::toDto).collect(Collectors.toList());
    }

    // Метод для сохранения пива
    public void saveBeer(BeerDTO beerDto) {
        BeerEntity beer = beerMapper.toEntity(beerDto);
        log.info("Добавление пива в базу данных");
        beerRepository.save(beer);
    }

    // Метод для удаления пива по айдишнику
    public void deleteBeerById(String id) {
        log.info("Удаление пива из базы данных");
        if (!beerRepository.existsById(id)) {
            throw new BeerNotFoundException("Пиво с данным идендификатором не найдено");
        }
        beerRepository.deleteById(id);
    }

    // Метод для удаления всего пива
    public void deleteAllBeers() {
        log.info("Удаление всех позиций пива из базы данных");
        beerRepository.deleteAll();
    }

    // Метод для изменения пива по айдишнику
    public void updateBeer(String id, BeerDTO beerDto) {
        Optional<BeerEntity> existingBeer = beerRepository.findById(id);
        if (existingBeer.isPresent()) {
            BeerEntity updatedBeer = beerMapper.toEntity(beerDto);
            updatedBeer.setName(updatedBeer.getName());
            updatedBeer.setColor(updatedBeer.getColor());
            updatedBeer.setPrice(updatedBeer.getPrice());
            updatedBeer.setVolume(updatedBeer.getVolume());
            updatedBeer.setAlcoholContent(updatedBeer.getAlcoholContent());
            updatedBeer.setIsFiltered(updatedBeer.getIsFiltered());
            log.info("Обновление пива в базе данных");
            beerRepository.save(updatedBeer);
        } else {
            throw new BeerNotFoundException("Пиво с данным идендификатором не найдено");
        }
    }

    // Метод для нахождения пива по айдишнику
    public BeerDTO findBeerById(String id) {
        return beerRepository.findById(id)
                .map(beerMapper::toDto)
                .orElseThrow(() -> new BeerNotFoundException("Пиво с данным идендификатором не найдено"));
    }
}
