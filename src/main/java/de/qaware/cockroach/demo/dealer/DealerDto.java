package de.qaware.cockroach.demo.dealer;

import lombok.Data;

import java.util.UUID;

@Data
public class DealerDto {
    private UUID id;
    private String name;
    private String countryCode;
}
