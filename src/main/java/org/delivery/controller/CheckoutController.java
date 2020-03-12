package org.delivery.controller;

import lombok.extern.slf4j.Slf4j;
import org.delivery.model.Checkout;
import org.delivery.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/checkouts")
@SessionAttributes("checkout")
public class CheckoutController {

    private CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutController(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        return "checkout";
    }

    @PostMapping
    public String processOrder(@Valid Checkout checkout, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "checkout";
        }

        checkoutRepository.save(checkout);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
