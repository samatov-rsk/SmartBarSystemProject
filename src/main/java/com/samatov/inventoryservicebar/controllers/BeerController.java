package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.dto.BeerDTO;
import com.samatov.inventoryservicebar.services.BeerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BeerController {

    BeerService beerService;

    @GetMapping("/all")
    public ResponseEntity<List<BeerDTO>> getAllBeers(){
       List<BeerDTO> beersDto = beerService.getAllBeers();
        return new ResponseEntity<>(beersDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable String id) {
        BeerDTO beerDto = beerService.findBeerById(id);
        return ResponseEntity.ok(beerDto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveBeer(@RequestBody  @Valid BeerDTO beerDto){
        beerService.saveBeer(beerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeerDTO> updateBeerById(@PathVariable String id, @Valid BeerDTO beerDto){
        beerService.updateBeer(id,beerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeerById(@PathVariable String id){
        beerService.deleteBeerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<BeerDTO> deleteAllBeers(){
        beerService.deleteAllBeers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
