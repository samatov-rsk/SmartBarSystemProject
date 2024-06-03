package repository;

// Импортировал каждую модель из пакета com.samatov.inventoryservicebar
import com.samatov.inventoryservicebar.model.Beer;
import com.samatov.inventoryservicebar.model.Cocktail;
import com.samatov.inventoryservicebar.model.Juice;
import com.samatov.inventoryservicebar.model.Liqueur;
import com.samatov.inventoryservicebar.model.Rum;
import com.samatov.inventoryservicebar.model.Vodka;
import com.samatov.inventoryservicebar.model.Whisky;
import com.samatov.inventoryservicebar.model.Wine;

// Импортировал интерфейс из MongoDB (который принимает в себя ключ, значение)
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ModelRepository<T, V> extends MongoRepository<T, V> {

// Репозитории для каждой модели
public interface BeerRepository extends ModelRepository<Beer, String> {

}

public interface CocktailRepository extends ModelRepository<Cocktail, String> {

}

public interface JuiceRepository extends ModelRepository<Juice, String> {

}

public interface LiqueurRepository extends ModelRepository<Liqueur, String> {

}

public interface RumRepository extends ModelRepository<Rum, String> {

}

public interface VodkaRepository extends ModelRepository<Vodka, String> {

}

public interface WhiskyRepository extends ModelRepository<Whisky, String> {

}

public interface WineRepository extends ModelRepository<Wine, String> {

}
}
