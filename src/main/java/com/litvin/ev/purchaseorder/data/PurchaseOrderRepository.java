package com.litvin.ev.purchaseorder.data;

import com.litvin.ev.purchaseorder.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder,Long> {
}
