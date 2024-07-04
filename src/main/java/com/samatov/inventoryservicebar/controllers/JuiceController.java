package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.entities.Juice;
import com.samatov.inventoryservicebar.services.JuiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/juice")
@RequiredArgsConstructor
public class JuiceController {

        private final JuiceService juiceService;

        @GetMapping("/all")
        public ResponseEntity<List<Juice>> getAllJuices(){
            List<Juice> juices =  juiceService.getAllJuices();
            return new ResponseEntity<>(juices, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Juice> getJuiceById(@PathVariable String id){
            return juiceService.findJuiceById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping("/add")
        public ResponseEntity<Void> saveJuice(@RequestBody Juice juice){
            juiceService.saveJuice(juice);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Juice> updateJuiceById(@PathVariable String id, Juice juice){
            juiceService.updateJuice(id, juice);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteJuiceById(@PathVariable String id){
            juiceService.deleteJuiceById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/delete/all")
        public ResponseEntity<Juice> deleteAllJuice(){
            juiceService.deleteAllJuices();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
