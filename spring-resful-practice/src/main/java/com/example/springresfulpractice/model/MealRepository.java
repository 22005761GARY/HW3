package com.example.springresfulpractice.model;

import com.example.springresfulpractice.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
