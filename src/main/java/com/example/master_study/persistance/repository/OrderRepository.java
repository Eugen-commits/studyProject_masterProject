package com.example.master_study.persistance.repository;

import com.example.master_study.persistance.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
