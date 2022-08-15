package com.example.springresfulpractice.service;

import com.example.springresfulpractice.controller.dto.request.CreateOrderRequest;
import com.example.springresfulpractice.controller.dto.request.UpdateOrderRequest;
import com.example.springresfulpractice.model.MealRepository;
import com.example.springresfulpractice.model.OrderRepository;
import com.example.springresfulpractice.model.entity.Meal;
import com.example.springresfulpractice.model.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MealRepository mealRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id){
        Order response = orderRepository.findById(id);
        return  response;
    }

    public String createOrder(CreateOrderRequest request){
        Order order = new Order();
        order.setSeq(request.getSeq());
        order.setTotalPrice(request.getTotalPrice());
        order.setWaiter(request.getWaiter());
        order.setMealList(request.getMealList());
        orderRepository.save(order);
        return "OK";
    }

    public String updateOrder(int seq, UpdateOrderRequest request){
        Order updatedOrder = orderRepository.findById(seq);
        if(null == updatedOrder){
            return "No existed order!";
        }

        if(null == updatedOrder.getWaiter() || null == updatedOrder.getMealList()){
            return "Wrong execution!";
        }

        if(null != updatedOrder){
            updatedOrder.setWaiter(request.getWaiter());
            updatedOrder.setMealList(request.getMealList());
            updatedOrder.setTotalPrice(updatedOrder.getTotalPrice());
        }
        orderRepository.save(updatedOrder);
        return "update complete!";
    }

    public String deleteOrder(int seq){
       Order deletedOrder = orderRepository.findById(seq);
       if(null == deletedOrder){
           return "no existed order!";
       }
       orderRepository.deleteById(seq);
        return "delete complete!";
    }
}
