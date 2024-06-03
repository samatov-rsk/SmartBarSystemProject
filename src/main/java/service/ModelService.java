package service;

import com.samatov.inventoryservicebar.model.*;

import repository.ModelRepository;

public interface ModelService {

    // Метод для поиска по айди барной продукции
    Beverage findById(Long id);

    // Метод для сохранение и изменение барной продукции
    Beverage saveBeverage(Beverage beverage);

    // Метод для удаления по айди барной продукции
    Beverage deleteById(Long id);

    // Метод для добавление новой позиции барной продукции
    Beverage updateBeverage(Beverage beverage);
}
