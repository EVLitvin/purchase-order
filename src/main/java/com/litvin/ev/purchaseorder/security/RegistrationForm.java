package com.litvin.ev.purchaseorder.security;

import com.litvin.ev.purchaseorder.PurchaseOrderUser;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private final String firstName;
    private final String lastName;
    private final String personalNumber;
    private final String phoneNumber;
    private final String email;
    private final String password;
    public PurchaseOrderUser toUser(PasswordEncoder passwordEncoder) {
        return new PurchaseOrderUser(firstName, lastName, personalNumber, phoneNumber,
                email, passwordEncoder.encode(password));
    }
}
