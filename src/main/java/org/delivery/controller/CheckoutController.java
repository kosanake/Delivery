package org.delivery.controller;

import lombok.extern.slf4j.Slf4j;
import org.delivery.model.Checkout;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/checkouts")
public class CheckoutController {

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("checkout", new Checkout());
        return "checkout";
    }

    @PostMapping
    public String processOrder(@Valid Checkout checout, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Checkout submitted: " + checout);

        return "redirect:/";
    }
}
