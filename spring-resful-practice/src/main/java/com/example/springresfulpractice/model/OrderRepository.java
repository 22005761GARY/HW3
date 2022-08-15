package com.example.springresfulpractice.model;

import com.example.springresfulpractice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findById(int id);
    Long deleteById(int id);

    @Modifying
    @Query(value = "INSERT INTO order_meal(order_seq, meal_id) VALUES(:order_seq, :meal_id)", nativeQuery = true)
    @Transactional
    void insertOrderMeal(
            @Param("order_seq") int order_seq,
            @Param("meal_id") int meal_id
    );
}
