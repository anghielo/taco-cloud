package com.paradigm_shifters.tacocloud.web;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import com.paradigm_shifters.tacocloud.model.Order;

@Slf4j
@Controller                             // When applied at class level, it specifies that the Controller class will handle REST requests
@RequestMapping("/orders")              // Class level page mapping
public class OrderController {

    @GetMapping("/current")                 // Method level page mapping
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
