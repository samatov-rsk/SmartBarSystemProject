/**
 * Аннотация @Service говорит о том что Spring будет управлять жизненым циклом этого класса
 * это значит что Spring будет создавать экземпляр этого класса и по мере необходимости уничтожать
 * а также предоставлять зависимости которые требуются этому классу через механизм DI
 *
 * Аннотация @Repository говорит о том что может взаимодействовать с БД, вэб-серверами, и другими ресурсами
 * основная задача обеспечить доступ к данным и их обработку с требованиями бизнес-логики приложения
 *
 * Аннотация @Autowired говорит о том что Spring автоматический будет инжектить
 * это значит что Spring будет автоматический предоставлять экземпляры необходимых класснов или же интерфейсов
 * которые требуются для работы данного компонента
 *
 * Аннотация @Override говорит о том что методы буду переопределены это значит что будет другая реализация методов
 * */

package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.samatov.inventoryservicebar.model.Beverage;
import repository.ModelRepository;

@Service
@Repository
public class BeerServiceImpl implements ModelService {
    @Autowired
    private ModelRepository.BeerRepository beerRepository;

    @Override
    public Beverage findById(Long id) {
        return null;
    }

    @Override
    public Beverage saveBeverage(Beverage beverage) {
        return null;
    }

    @Override
    public Beverage deleteById(Long id) {
        return null;
    }

    @Override
    public Beverage updateBeverage(Beverage beverage) {
        return null;
    }
}
