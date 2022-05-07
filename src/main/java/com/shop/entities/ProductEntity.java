package com.shop.entities;

import com.shop.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javamoney.moneta.FastMoney;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = ProductEntity.TABLE_NAME)
public class ProductEntity {

    public static final String SEQ_NAME = "product_id_seq";
    public static final String TABLE_NAME = "products";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ProductEntity.SEQ_NAME)
    @SequenceGenerator(name = ProductEntity.SEQ_NAME, sequenceName = ProductEntity.SEQ_NAME, allocationSize = 1)
    private Long id;

    private String name;

    private String description;

    private FastMoney price;

    @OneToMany
    private Set<Tag> tags;

    @ManyToMany(mappedBy = "products")
    private List<InvoiceEntity> invoices;

}