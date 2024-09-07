package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.dto.VodkaDTO;
import com.samatov.inventoryservicebar.services.VodkaService;
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
@RequestMapping("api/v1/vodka")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VodkaController {

    VodkaService vodkaService;

    @GetMapping("/all")
    public ResponseEntity<List<VodkaDTO>> getAllVodka(){
        List<VodkaDTO> vodkasDto =  vodkaService.getAllVodkas();
        return new ResponseEntity<>(vodkasDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VodkaDTO> getVodkaById(@PathVariable String id){
        VodkaDTO vodkaDto = vodkaService.findVodkaById(id);
        return ResponseEntity.ok(vodkaDto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveVodka(@RequestBody  @Valid VodkaDTO vodkaDto){
        vodkaService.saveVodka(vodkaDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VodkaDTO> updateVodkaById(@PathVariable String id, @Valid VodkaDTO vodkaDto){
        vodkaService.updateVodka(id,vodkaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVodkaById(@PathVariable String id){
        vodkaService.deleteVodkaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<VodkaDTO> deleteAllVodkas(){
        vodkaService.deleteAllVodkas();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
