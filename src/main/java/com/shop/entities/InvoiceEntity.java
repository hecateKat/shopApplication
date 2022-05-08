package com.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "Invoice")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity that = (InvoiceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(basket, that.basket) && Objects.equals(client, that.client) && Objects.equals(invoiceNumber, that.invoiceNumber) && Objects.equals(sellingDate, that.sellingDate) && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(printDate, that.printDate) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, basket, client, invoiceNumber, sellingDate, paymentDate, printDate, products);
    }
}