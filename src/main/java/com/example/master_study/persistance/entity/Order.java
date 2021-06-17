package com.example.master_study.persistance.entity;

import com.example.master_study.persistance.enums.orderStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User client;

    @Column (nullable = false)
    private LocalDateTime localDateTime;

    @Column(nullable = false)
    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private orderStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "master" , nullable = false)
    private Master master;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (
            name = "order_work",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "work_id")}
    )
    private Set<Work> work;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(client, order.client) &&
                Objects.equals(localDateTime, order.localDateTime) &&
                Objects.equals(price, order.price) &&
                Objects.equals(address, order.address) &&
                Objects.equals(master, order.master) &&
                Objects.equals(work, order.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, localDateTime, price, address, master, work);
    }
}
