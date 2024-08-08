package com.samatov.inventoryservicebar.controllers;


import com.samatov.inventoryservicebar.entities.Rum;
import com.samatov.inventoryservicebar.services.RumService;
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
@RequestMapping("api/v1/rum")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RumController {

    private final RumService rumService;

    @GetMapping("/all")
    public ResponseEntity<List<Rum>> getAllRums() {
        List<Rum> rums = rumService.getAllRums();
        return new ResponseEntity<>(rums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rum> getRumById(@PathVariable String id){
        return rumService.findRumById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveRum(@RequestBody Rum rum){
        rumService.saveRum(rum);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rum> updateRumById(@PathVariable String id, Rum rum){
        rumService.updateRum(id, rum);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRumById(@PathVariable String id){
        rumService.deleteRumById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Rum> deleteAllRums(){
        rumService.deleteAllRums();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
