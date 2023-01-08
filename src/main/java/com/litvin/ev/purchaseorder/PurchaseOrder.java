package com.litvin.ev.purchaseorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String contractNumber;
    private String contractAddendum;
    private String isotope;
    private double isotopeEnrichment;
    private String isotopeChemicalForm;
    private double isotopeElementaryWeight;
    private double isotopeLigatureWeight;

}