package com.example.springresfulpractice.controller.dto.request;

import com.example.springresfulpractice.model.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private  int seq;
    private String waiter;
    private int totalPrice;
    private List<Meal> mealList;
}
