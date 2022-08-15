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
public class UpdateOrderRequest {
    private String waiter;
    private int totalPrice;
    private List<Meal> mealList;
}
