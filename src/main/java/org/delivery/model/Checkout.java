package org.delivery.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    private Date placedAt;

    @ManyToMany(targetEntity = Delivery.class)
    private List<Delivery> deliveryList = new ArrayList<>();

    @PrePersist
    void placedAt() {
        placedAt = new Date();
    }
}