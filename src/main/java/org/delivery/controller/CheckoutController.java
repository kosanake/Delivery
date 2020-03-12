package org.delivery.controller;

import lombok.extern.slf4j.Slf4j;
import org.delivery.model.Checkout;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/checkouts")
@SessionAttributes("checkout")
public class CheckoutController {

    @GetMapping("/current")
    public String orderForm(Model model) {
        return "checkout";
    }

    @PostMapping
    public String processOrder(@Valid Checkout checout, Errors errors) {
        if (errors.hasErrors()) {
            return "checkout";
        }

        log.info("Checkout submitted: " + checout);

        return "redirect:/";
    }
}
