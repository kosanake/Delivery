package org.delivery.controller;

import lombok.extern.slf4j.Slf4j;
import org.delivery.model.Checkout;
import org.delivery.model.Delivery;
import org.delivery.model.Item;
import org.delivery.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("delivery")
@SessionAttributes("checkout")
public class DeliveryController {

    private ItemRepository itemRepository;

    @Autowired
    public DeliveryController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @ModelAttribute(name = "checkout")
    public Checkout checkout() {
        return new Checkout();
    }

    @ModelAttribute(name = "delivery")
    public Delivery delivery() {
        return new Delivery();
    }

    @GetMapping
    public String showList(Model model) {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        model.addAttribute("items", items);
        return "delivery";
    }

    @PostMapping
    public String submitDelivery(@Valid @ModelAttribute Delivery delivery) {
        log.error("Process delivery: " + delivery);
        return "redirect:/checkouts/current";
    }
}
