/**
 * Аннотация @Service говорит о том что Spring будет управлять жизненым циклом этого класса
 * это значит что Spring будет создавать экземпляр этого класса и по мере необходимости уничтожать
 * а также предоставлять зависимости которые требуются этому классу через механизм DI
 *
 * Аннотация @Autowired говорит о том что Spring автоматический будет инжектить
 * это значит что Spring будет автоматический предоставлять экземпляры необходимых класснов или же интерфейсов
 * которые требуются для работы данного компонента
 *
 * Аннотация @Override говорит о том что методы буду переопределены это значит что будет другая реализация методов
 * */

package com.samatov.inventoryservicebar.service;
import com.samatov.inventoryservicebar.model.Beer;
import com.samatov.inventoryservicebar.repository.BeerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BeerService  {

    @Autowired
    private BeerRepository beerRepository;

    // Метод для получение все пиво
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }
    // Метод для сохрание пиво
    public void saveBeer(Beer beer) {
        beerRepository.save(beer);
    }
    // Метод для удаление все пиво по айдишнику
    public void deleteBeerAllById() {
        beerRepository.deleteAll();
    }
    // Метод для измененение пиво
    public void updateBeer(Beer beer) {
        beerRepository.save(beer);
    }
    // Метод для нахождение пиво по айдишнику
    public void findBeerById(String id) {
        beerRepository.findById(id);
    }

}
