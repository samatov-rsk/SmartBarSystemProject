package com.samatov.inventoryservicebar.common.handler;

import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.BeerNotFoundException;
import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.CocktailNotFoundException;
import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.JuiceNotFoundException;
import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.LiqueurNotFoundException;
import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.RumNotFoundException;
import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.VodkaNotFoundException;
import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.WhiskyNotFoundException;
import com.samatov.inventoryservicebar.common.exceptions.notfoundexceptions.WineNotFoundException;
import com.samatov.inventoryservicebar.common.exceptions.validationexceptions.InvalidBeerDataException;
import com.samatov.inventoryservicebar.common.exceptions.validationexceptions.InvalidCocktailDataException;
import com.samatov.inventoryservicebar.common.exceptions.validationexceptions.InvalidJuiceDataException;
import com.samatov.inventoryservicebar.common.exceptions.validationexceptions.InvalidLiqueurDataException;
import com.samatov.inventoryservicebar.common.exceptions.validationexceptions.InvalidRumDataException;
import com.samatov.inventoryservicebar.common.exceptions.validationexceptions.InvalidVodkaDataException;
import com.samatov.inventoryservicebar.common.exceptions.validationexceptions.InvalidWhiskyDataException;
import com.samatov.inventoryservicebar.common.exceptions.validationexceptions.InvalidWineDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Глобальный обработчик исключений
 */

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(BeerNotFoundException.class)
    public ResponseEntity<String> handleBeerNotFoundException(BeerNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Пиво не найдено: " + e.getMessage());
    }

    @ExceptionHandler(InvalidBeerDataException.class)
    public ResponseEntity<String> handleBeerInvalidBeerDataException(InvalidBeerDataException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Некорректные данные для пива: " + e.getMessage());
    }

    @ExceptionHandler(CocktailNotFoundException.class)
    public ResponseEntity<String> handleCocktailNotFoundException(CocktailNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Коктейль не найден: " + e.getMessage());
    }

    @ExceptionHandler(InvalidCocktailDataException.class)
    public ResponseEntity<String> handleCocktailInvalidDataException(InvalidCocktailDataException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Некорректные данные для коктейля: " + e.getMessage());
    }

    @ExceptionHandler(JuiceNotFoundException.class)
    public ResponseEntity<String> handleJuiceNotFoundException(JuiceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Сок не найден: " + e.getMessage());
    }

    @ExceptionHandler(InvalidJuiceDataException.class)
    public ResponseEntity<String> handleJuiceInvalidDataException(InvalidJuiceDataException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Некорректные данные для сока:" + e.getMessage());
    }

    @ExceptionHandler(LiqueurNotFoundException.class)
    public ResponseEntity<String> handleLiqueurNotFoundException(LiqueurNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ликер не найден: " + e.getMessage());
    }

    @ExceptionHandler(InvalidLiqueurDataException.class)
    public ResponseEntity<String> handleInvalidLiqueurDataException(InvalidLiqueurDataException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Некорректные данные для ликера: " + e.getMessage());
    }

    @ExceptionHandler(RumNotFoundException.class)
    public ResponseEntity<String> handleRumNotFoundException(RumNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ром не найден:" + e.getMessage());
    }

    @ExceptionHandler(InvalidRumDataException.class)
    public ResponseEntity<String> handleInvalidRumDataException(InvalidRumDataException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Некорретные данные для рома: " + e.getMessage());
    }

    @ExceptionHandler(VodkaNotFoundException.class)
    public ResponseEntity<String> handleVodkaNotFoundException(VodkaNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Водка не найдено:" + e.getMessage());
    }

    @ExceptionHandler(InvalidVodkaDataException.class)
    public ResponseEntity<String> handleInvalidVodkaDataException(InvalidVodkaDataException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Некорретные данные для водки: " + e.getMessage());
    }

    @ExceptionHandler(WhiskyNotFoundException.class)
    public ResponseEntity<String> handleWhiskyNotFoundException(WhiskyNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Виски не найден:" + e.getMessage());
    }

    @ExceptionHandler(InvalidWhiskyDataException.class)
    public ResponseEntity<String> handleInvalidWhiskyDataException(InvalidWhiskyDataException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Некорретные данные для виски: " + e.getMessage());
    }

    @ExceptionHandler(WineNotFoundException.class)
    public ResponseEntity<String> handleWineNotFoundException(WineNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Вино не найдено:" + e.getMessage());
    }

    @ExceptionHandler(InvalidWineDataException.class)
    public ResponseEntity<String> handleInvalidWineDataException(InvalidWineDataException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Некорретные данные для вина: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Внутренняя ошибка сервера: " + e.getMessage());
    }
}
