package com.litvin.ev.purchaseorder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/purchase_orders")
@Controller
public class PurchaseOrdersController {

    @GetMapping
    public String showPurchaseOrdersPage() {
        return "purchase_orders";
    }
}
