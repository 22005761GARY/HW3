package com.example.springresfulpractice.controller;

import com.example.springresfulpractice.controller.dto.request.CreateOrderRequest;
import com.example.springresfulpractice.controller.dto.request.UpdateOrderRequest;
import com.example.springresfulpractice.controller.dto.response.StatusResponse;
import com.example.springresfulpractice.model.entity.Order;
import com.example.springresfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id){
        Order order = this.orderService.getOrderById(id);
        return order;
    }

    @PostMapping()
    public StatusResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        String response = this.orderService.createOrder(createOrderRequest);
        return  new StatusResponse((response));
    }

    @PutMapping("/{seq}")
    public StatusResponse updateOrder(@PathVariable int seq, @RequestBody UpdateOrderRequest updateOrderRequest){
        String response = orderService.updateOrder(seq, updateOrderRequest);
        return new StatusResponse(response);
    }

    @DeleteMapping("/{seq}")
    public StatusResponse deleteOrder(@PathVariable int seq){
        String response = orderService.deleteOrder(seq);
        return new StatusResponse(response);
    }
}
