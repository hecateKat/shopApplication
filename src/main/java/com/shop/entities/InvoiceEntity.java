package com.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InvoiceEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private BasketEntity basket;

    @ManyToOne
    private ClientEntity client;

    private String invoiceNumber;

    private LocalDate sellingDate;

    private LocalDate paymentDate;

    private LocalDate printDate;

    @ManyToMany
    private List<ProductEntity> products;
}