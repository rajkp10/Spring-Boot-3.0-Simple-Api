package com.practiceproject1.simpleapi.laptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/laptop")
public class LaptopController {
    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping
    public ResponseEntity<?> getAllLaptops(){
        return new ResponseEntity<>(laptopService.getAllLaptops(), HttpStatus.OK);
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<?> createLaptop(@PathVariable("studentId")UUID studentId,@RequestBody Laptop laptop){
        return new ResponseEntity<>(laptopService.createLaptop(studentId, laptop), HttpStatus.CREATED);
    }
}
