package com.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = ClientEntity.TABLE_NAME)
public class ClientEntity {

    public static final String SEQ_NAME = "client_id_seq";
    public static final String TABLE_NAME = "clients";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ClientEntity.SEQ_NAME)
    @SequenceGenerator(name = ClientEntity.SEQ_NAME, sequenceName = ClientEntity.SEQ_NAME, allocationSize = 1)
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
