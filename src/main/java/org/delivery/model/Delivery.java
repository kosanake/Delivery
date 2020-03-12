package org.delivery.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    private Date createdAt;
    @ManyToMany(targetEntity = Item.class)
    @Size(min = 1)
    private List<Item> items = new ArrayList<>();

    @PrePersist
    public void createdAt() {
        createdAt = new Date();
    }
}
