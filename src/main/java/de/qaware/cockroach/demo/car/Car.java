package de.qaware.cockroach.demo.car;

import de.qaware.cockroach.demo.dealer.Dealer;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name="VIN", nullable = false)
    private String vin;

    @ManyToOne
    @JoinColumn(name = "DEALER_ID", nullable = false)
    private Dealer dealer;

    public Car() {
        this.id = UUID.randomUUID();
    }
}
