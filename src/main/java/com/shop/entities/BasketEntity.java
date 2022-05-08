package com.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javamoney.moneta.FastMoney;

import javax.persistence.*;
import java.util.List;

@Entity
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

    private FastMoney value;

    @ManyToOne(cascade = CascadeType.ALL)
    private ClientEntity client;
}