package org.delivery.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 5)
    private String name;
    private Date createdAt;
    @ManyToMany(targetEntity = Item.class)
    @Size(min = 1)
    private List<Item> items;

    @PrePersist
    public void createdAt() {
        createdAt = new Date();
    }
}
