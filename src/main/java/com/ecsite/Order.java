package com.ecsite;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Integer orderId;

  @Column(name="user_id")
  private Integer userId;
  @Column(name="order_date")
  private LocalDateTime orderDate;

  public Integer getOrderId() {
    return orderId;
  }

  public Integer getUserId() {
    return userId;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public void setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }
}
