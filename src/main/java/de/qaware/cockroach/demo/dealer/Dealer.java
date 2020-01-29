package de.qaware.cockroach.demo.dealer;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "DEALER")
public class Dealer {

    @Id
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COUNTRYCODE", nullable = false)
    private String countryCode;

    public Dealer() {
        this.id = UUID.randomUUID();
    }
}
