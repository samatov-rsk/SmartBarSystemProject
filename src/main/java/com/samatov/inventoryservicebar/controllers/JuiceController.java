package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.entities.Juice;
import com.samatov.inventoryservicebar.services.JuiceService;
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
@RequestMapping("/api/v1/juice")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JuiceController {

        JuiceService juiceService;

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
