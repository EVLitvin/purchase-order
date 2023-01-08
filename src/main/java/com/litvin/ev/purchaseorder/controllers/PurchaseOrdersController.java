package com.litvin.ev.purchaseorder.controllers;

import com.litvin.ev.purchaseorder.PurchaseOrder;
import com.litvin.ev.purchaseorder.PurchaseOrderUser;
import com.litvin.ev.purchaseorder.data.PurchaseOrderRepository;
import com.litvin.ev.purchaseorder.data.PurchaseOrderUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/purchase_orders")
@Controller
@SessionAttributes("order")
public class PurchaseOrdersController {

    final PurchaseOrderRepository purchaseOrderRepository;
    final PurchaseOrderUserRepository purchaseOrderUserRepository;

    public PurchaseOrdersController(PurchaseOrderRepository purchaseOrderRepository,
                                    PurchaseOrderUserRepository purchaseOrderUserRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderUserRepository = purchaseOrderUserRepository;
    }

    @ModelAttribute(name = "purchaseOrder")
    public PurchaseOrder purchaseOrder() {
        return new PurchaseOrder();
    }

    @ModelAttribute(name = "purchaseOrderUser")
    public PurchaseOrderUser purchaseOrderUser(Principal principal) {
        String personalNumber = principal.getName();
        return purchaseOrderUserRepository.findByPersonalNumber(personalNumber);
    }

    @ModelAttribute(name = "date")
    public String date() {
        String pattern = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    @GetMapping
    public String showPurchaseOrdersPage(Model model) {
        model.addAttribute("allPurchaseOrders", purchaseOrderRepository.findAll());
        return "purchase_orders";
    }

    @PostMapping()
    public String addPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.save(purchaseOrder);
        return "redirect:/purchase_orders";
    }
}
