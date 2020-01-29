package de.qaware.cockroach.demo.car;

import lombok.Data;

import java.util.UUID;

@Data
public class CarDto {
    private UUID id;
    private String name;
    private String vin;
    private UUID dealer;
}
