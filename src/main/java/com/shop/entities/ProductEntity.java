package com.shop.entities;

import com.shop.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javamoney.moneta.FastMoney;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Product")
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

    private BigDecimal price;

    @ManyToMany
    private Set<Tag> tags;

    @ManyToMany(mappedBy = "products")
    private List<InvoiceEntity> invoices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(tags, that.tags) && Objects.equals(invoices, that.invoices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, tags, invoices);
    }
}