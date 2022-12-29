package com.litvin.ev.purchaseorder.security;

import com.litvin.ev.purchaseorder.PurchaseOrderUser;
import com.litvin.ev.purchaseorder.data.PurchaseOrderUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderUserDetailsService
        implements org.springframework.security.core.userdetails.UserDetailsService {

    private PurchaseOrderUserRepository userRepo;

    @Autowired
    public PurchaseOrderUserDetailsService(PurchaseOrderUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String personalNumber)
            throws UsernameNotFoundException {
        PurchaseOrderUser user = userRepo.findByPersonalNumber(personalNumber);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException(
                "User with'" + personalNumber + "' not found");
    }

}
