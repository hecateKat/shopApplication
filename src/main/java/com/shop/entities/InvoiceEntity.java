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
@Table(name = InvoiceEntity.TABLE_NAME)
public class InvoiceEntity {

    public static final String SEQ_NAME = "invoice_id_seq";
    public static final String TABLE_NAME = "invoices";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = InvoiceEntity.SEQ_NAME)
    @SequenceGenerator(name = InvoiceEntity.SEQ_NAME, sequenceName = InvoiceEntity.SEQ_NAME, allocationSize = 1)
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