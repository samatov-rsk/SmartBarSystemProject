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


@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;
    
    //TODO Пиши правильно комментарии (Метод для получениЯ всего пивА) - исправить 
    // Метод для получение все пиво
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }
    
    //TODO Пиши правильно комментарии (Метод для сохранениЯ пивА) - исправить 
    // Метод для сохрание пиво 
    public void saveBeer(Beer beer) {
        beerRepository.save(beer);
    }

    //TODO Пиши правильно комментарии (Метод для удалениЯ пивА по айдишнику) - исправить 
    // Метод для удаление пива по айдишнику
    public void deleteBeerById(String id) {
        beerRepository.deleteById(id);
    }

    //TODO Пиши правильно комментарии (Метод для удалениЯ всего пива. Пиши или пиво или сущность) - исправить 
    // Метод для удаление всех сущностей
    public void deleteAllBeers() {
        beerRepository.deleteAll();
    }
    
    //TODO Пиши правильно комментарии (Метод для изменениЯ пивА по айдишнику) - исправить метод нет айдишника по которому мы меняем
    // Метод для измененение пиво
    public void updateBeer(Beer beer) {
        beerRepository.save(beer);
    }
    //TODO Пиши правильно комментарии (Метод для нахождениЯ пивА по айдишнику) - исправить метод, метод должен возвращать сущность с БД
    // Метод для нахождение пиво по айдишнику
    public void findBeerById(String id) {
        beerRepository.findById(id);
    }

}
