package com.clebergraciano.apiproducerkafkajava.controller;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CarDto {

    private String id;
    private String model;
    private String color;

}
