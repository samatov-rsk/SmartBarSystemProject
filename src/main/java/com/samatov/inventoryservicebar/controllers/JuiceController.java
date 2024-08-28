package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.dto.JuiceDTO;
import com.samatov.inventoryservicebar.services.JuiceService;
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
@RequestMapping("/api/v1/juice")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JuiceController {

        JuiceService juiceService;

        @GetMapping("/all")
        public ResponseEntity<List<JuiceDTO>> getAllJuices(){
            List<JuiceDTO> juicesDto =  juiceService.getAllJuices();
            return new ResponseEntity<>(juicesDto, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<JuiceDTO> getJuiceById(@PathVariable String id){
            JuiceDTO juiceDto = juiceService.findJuiceById(id);
            return ResponseEntity.ok(juiceDto);
        }

        @PostMapping("/add")
        public ResponseEntity<Void> saveJuice(@RequestBody @Valid JuiceDTO juiceDto){
            juiceService.saveJuice(juiceDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<JuiceDTO> updateJuiceById(@PathVariable String id, @Valid JuiceDTO juiceDto){
            juiceService.updateJuice(id, juiceDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteJuiceById(@PathVariable String id){
            juiceService.deleteJuiceById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/delete/all")
        public ResponseEntity<JuiceDTO> deleteAllJuice(){
            juiceService.deleteAllJuices();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
