package service;

import com.samatov.inventoryservicebar.model.Beverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.ModelRepository;

@Service
@Repository
public class JuiceServiceImpl implements ModelService{
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
