package com.samatov.inventoryservicebar.controllers;


import com.samatov.inventoryservicebar.entities.Vodka;
import com.samatov.inventoryservicebar.services.VodkaService;
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
@RequestMapping("api/v1/vodka")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VodkaController {

    VodkaService vodkaService;

    @GetMapping("/all")
    public ResponseEntity<List<Vodka>> getAllVodka(){
        List<Vodka> vodkas =  vodkaService.getAllVodkas();
        return new ResponseEntity<>(vodkas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vodka> getVodkaById(@PathVariable String id){
        return vodkaService.findVodkaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveVodka(@RequestBody Vodka vodka){
        vodkaService.saveVodka(vodka);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vodka> updateVodkaById(@PathVariable String id, Vodka vodka){
        vodkaService.updateVodka(id,vodka);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVodkaById(@PathVariable String id){
        vodkaService.deleteVodkaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Vodka> deleteAllVodkas(){
        vodkaService.deleteAllVodkas();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
