package com.clebergraciano.apiproducerkafkajava.controller;

import com.clebergraciano.apiproducerkafkajava.producer.CarProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarProducer carProducer;

    @Autowired
    public CarController(CarProducer carProducer) {
        this.carProducer = carProducer;
    }

    @PostMapping
    public ResponseEntity<CarDto> send(@RequestBody CarDto carDto){
        CarDto car = CarDto.builder().id(UUID.randomUUID().toString()).model(carDto.getModel()).color(carDto.getColor()).build();
        carProducer.send(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }
}
