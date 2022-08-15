package com.example.springresfulpractice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column
    private int seq;

    @Column
    private int totalPrice;

    @Column
    private String waiter;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_meal",
            joinColumns = @JoinColumn(name = "order_seq"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> mealList;

    public int getTotalPrice() {
        this.totalPrice = 0;
        for (Meal meal : this.getMealList()) {
            this.totalPrice += meal.getPrice();
        }
        return totalPrice;
    }
}
