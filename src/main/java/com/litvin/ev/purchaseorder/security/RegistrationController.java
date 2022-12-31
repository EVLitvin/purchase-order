package com.litvin.ev.purchaseorder.security;

import com.litvin.ev.purchaseorder.data.PurchaseOrderUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/registration")
@Controller public class RegistrationController {
    private PurchaseOrderUserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(PurchaseOrderUserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registrationForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/";
    }
    
}
