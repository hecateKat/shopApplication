package com.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javamoney.moneta.FastMoney;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity(name = "Basket")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = BasketEntity.TABLE_NAME)
public class BasketEntity {

    public static final String SEQ_NAME = "basket_id_seq";
    public static final String TABLE_NAME = "baskets";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = BasketEntity.SEQ_NAME)
    @SequenceGenerator(name = BasketEntity.SEQ_NAME, sequenceName = BasketEntity.SEQ_NAME, allocationSize = 1)
    private Long id;

    @OneToMany
    private List<ProductEntity> products;

    private BigDecimal value;

    @ManyToOne(cascade = CascadeType.ALL)
    private ClientEntity client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketEntity that = (BasketEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(products, that.products) && Objects.equals(value, that.value) && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, value, client);
    }
}