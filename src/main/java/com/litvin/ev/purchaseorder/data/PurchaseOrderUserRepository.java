package com.litvin.ev.purchaseorder.data;

import org.springframework.data.repository.CrudRepository;
import com.litvin.ev.purchaseorder.PurchaseOrderUser;

public interface PurchaseOrderUserRepository extends CrudRepository<PurchaseOrderUser, Long> {

    PurchaseOrderUser findByPersonalNumber(String personalNumber);

}
