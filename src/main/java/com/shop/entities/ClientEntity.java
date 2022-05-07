package com.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    @NIP
    private String nip;

    @REGON
    private String regon;

    @OneToMany(mappedBy = "client")
    private Set<BasketEntity> baskets;
}
