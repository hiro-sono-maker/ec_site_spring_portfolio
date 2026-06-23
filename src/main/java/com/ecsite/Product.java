package com.ecsite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name ="products")
public class Product {
  @Id
  @Column(name = "product_id")
  private String productId;
  @Column(name = "product_name")
  private String productName;
  @Column(name = "price")
  private int price;
  @Column(name = "stock")
  private int stock;


  @Column(name = "image_data")
  private byte[] imageData;

  public byte[] getImageData() {
    return imageData;
  }

  public void setImageData(
      byte[] imageData) {
    this.imageData = imageData;
  }

  public Product() {
  }
  public String getProductId() {
    return productId;
  }
  public void setProductId(String productId) {
    this.productId = productId;
  }
  public String getProductName() {
    return productName;
  }
  public void setProductName(String productName) {
    this.productName = productName;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }


  @Column(name = "active")
  private Boolean active;

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}
