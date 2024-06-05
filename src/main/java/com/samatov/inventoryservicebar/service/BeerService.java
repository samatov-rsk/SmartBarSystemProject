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

package com.samatov.inventoryservicebar.service;

import com.samatov.inventoryservicebar.model.Beer;
import com.samatov.inventoryservicebar.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class BeerService {

    private Logger logger = Logger.getGlobal();

    @Autowired
    private BeerRepository beerRepository;

    // Метод для получение всего пива
    public List<Beer> getAllBeers() {
        logger.info("Всю позицию пива получили из база данных ");
        return beerRepository.findAll();
    }

    // Метод для сохрания пива
    public void saveBeer(Beer beer) {
        logger.info("Пива добавлено в базу данных ");
        beerRepository.save(beer);
    }

    // Метод для удаления пива по айдишнику
    public void deleteBeerById(String id) {
        logger.info("Пива успешно удалилось из база данных ");
        beerRepository.deleteById(id);
    }

    // Метод для удаления всего пива сущность
    public void deleteAllBeers() {
        logger.info("Вся позиция пива удалилось из база данных ");
        beerRepository.deleteAll();
    }

    // Метод для изменения пива по айдишнику
    public void updateBeer(Beer beer) {
        logger.info("Пива обновилась в базе данных ");
        beerRepository.save(beer);
    }

    // Метод для нахождение пиво по айдишнику
    public Optional<Beer> findBeerById(String id) {
        try {
            return beerRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка. Не удалось найти пива по ID " + e);
        }
    }
}
