package com.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Client")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(nip, that.nip) && Objects.equals(regon, that.regon) && Objects.equals(baskets, that.baskets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, nip, regon, baskets);
    }
}
