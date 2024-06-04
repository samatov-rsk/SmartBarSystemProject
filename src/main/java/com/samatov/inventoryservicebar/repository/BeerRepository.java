package com.samatov.inventoryservicebar.repository;
/**
 * Аннотация @Repository говорит о том что может взаимодействовать с БД, вэб-серверами, и другими ресурсами
 * основная задача обеспечить доступ к данным и их обработку с требованиями бизнес-логики приложения
 * */

// Импортировал модель из пакета com.samatov.inventoryservicebar.model
import com.samatov.inventoryservicebar.model.Beer;

// Импортировал интерфейс из MongoDB (который принимает в себя ключ, значение)
import org.springframework.data.mongodb.repository.MongoRepository;

// Ипортировал аннотацию @Repository для работы с БД
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends MongoRepository<Beer, String> {

}
