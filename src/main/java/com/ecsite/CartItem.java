package com.ecsite;

public class CartItem {

  private String productId;

  private String productName;

  private Integer price;

  private Integer quantity;

      private byte[] imageData;

  public byte[] getImageData() {
    return imageData;
  }

  public void setImageData(
      byte[] imageData) {
    this.imageData = imageData;
  }




  public CartItem() {
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

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}