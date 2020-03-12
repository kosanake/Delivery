package org.delivery.controller.converter;

import org.delivery.model.Item;
import org.delivery.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter implements Converter<Long, Item> {

    private ItemRepository itemRepository;

    @Autowired
    public ItemConverter(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item convert(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
