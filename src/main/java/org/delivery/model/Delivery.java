package org.delivery.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Delivery {
    private Long id;
    private String name;
    private List<Long> items;
}
