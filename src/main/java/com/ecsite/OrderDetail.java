package com.ecsite;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "detail_id")
  private Integer detailId;

  @Column(name = "order_id")
  private Integer orderId;

  @Column(name = "product_id")
  private String productId;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "price")
  private Integer price;

  @Transient
  private String productName;

  public Integer getDetailId() {
    return detailId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public String getProductId() {
    return productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Integer getPrice() {
    return price;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}
