package com.javaGraphql.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaGraphql.com.entity.Orders;
import com.javaGraphql.com.repositery.OrdersRepositery;

@RestController
public class OrderGraphqlController {

	@Autowired
	private OrdersRepositery orderRepo;
	
	
	@MutationMapping
	public Orders createOrders(@Argument String orderaddress,@Argument String ordertype,@Argument String orderstatus,
			@Argument Integer orderpincode,@Argument Float ordersprice,@Argument Integer user) {
		
		Orders orders= new Orders();
	//	User userOder= new User();
		orders.setOrderaddress(orderaddress);
		orders.setOrderpincode(orderpincode);
		orders.setOrdersprice(ordersprice);
		orders.setOrderstatus(orderstatus);
		orders.setOrdertype(ordertype);
		
		//userOder.setUid(user);
		
		//List<Object> ordersUser = List.of(orders,userOder);
		
		Orders saveOrders = orderRepo.save(orders);
		return saveOrders;
	}
}
