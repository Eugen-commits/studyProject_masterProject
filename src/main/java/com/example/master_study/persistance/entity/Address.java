package com.example.master_study.persistance.entity;

import com.example.master_study.persistance.enums.Districts;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String addressLine;

    @Column(nullable = false)
    @Enumerated (EnumType.STRING)
    private Districts district;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(addressLine, address.addressLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressLine);
    }
}
