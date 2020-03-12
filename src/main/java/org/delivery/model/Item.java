package org.delivery.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
public class Item {
    @Id
    private final Long id;
    private final String name;
}
