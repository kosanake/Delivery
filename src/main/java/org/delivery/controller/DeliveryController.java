package org.delivery.controller;

import lombok.extern.slf4j.Slf4j;
import org.delivery.model.Delivery;
import org.delivery.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("delivery")
public class DeliveryController {

    @GetMapping
    public String showList(Model model) {
        List<Item> items = Arrays.asList(
                new Item(1L, "Item1"),
                new Item(2L, "Item2"),
                new Item(3L, "Item3"),
                new Item(4L, "Item4"));
        model.addAttribute("items", items);
        model.addAttribute("delivery", new Delivery());
        return "delivery";
    }

    @PostMapping
    public String submitDelivery(@Valid @ModelAttribute("delivery") Delivery delivery) {
        log.error("Process delivery: " + delivery);
        return "redirect:/checkouts/current";
    }
}
