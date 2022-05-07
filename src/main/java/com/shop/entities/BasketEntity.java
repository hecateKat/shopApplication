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
public class BasketEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<ProductEntity> products;

    private FastMoney value;

    @ManyToOne
    private ClientEntity client;
}