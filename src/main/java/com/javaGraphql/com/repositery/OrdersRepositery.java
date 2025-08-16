package com.javaGraphql.com.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaGraphql.com.entity.Orders;

@Repository
public interface OrdersRepositery extends JpaRepository<Orders, Integer>{


}
