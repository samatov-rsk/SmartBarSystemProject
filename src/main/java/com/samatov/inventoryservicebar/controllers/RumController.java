package com.samatov.inventoryservicebar.controllers;

import com.samatov.inventoryservicebar.dto.RumDTO;
import com.samatov.inventoryservicebar.services.RumService;
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
@RequestMapping("api/v1/rum")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RumController {

     RumService rumService;

    @GetMapping("/all")
    public ResponseEntity<List<RumDTO>> getAllRums() {
        List<RumDTO> rumsDto = rumService.getAllRums();
        return new ResponseEntity<>(rumsDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RumDTO> getRumById(@PathVariable String id){
        RumDTO rumDto = rumService.findRumById(id);
        return ResponseEntity.ok(rumDto);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveRum(@RequestBody @Valid RumDTO rumDto){
        rumService.saveRum(rumDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RumDTO> updateRumById(@PathVariable String id, @Valid RumDTO rumDto){
        rumService.updateRum(id, rumDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRumById(@PathVariable String id){
        rumService.deleteRumById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<RumDTO> deleteAllRums(){
        rumService.deleteAllRums();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
