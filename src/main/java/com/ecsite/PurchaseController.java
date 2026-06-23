package com.ecsite;

import java.util.List;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PurchaseController {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  @GetMapping("/purchaseConfirm")
  public String purchaseConfirm(
          HttpSession session,
          Model model) {

            User loginUser = (User) session.getAttribute(
              "loginUser");

      if (loginUser == null) {

          return "purchaseLogin";
      }

      List<CartItem> cart = (List<CartItem>) session.getAttribute(
              "cart");

      int total = 0;

      if (cart != null) {

          for (CartItem item : cart) {

              total += item.getPrice()
                      * item.getQuantity();
          }

      }

      model.addAttribute(
              "cart",
              cart);

      model.addAttribute(
              "total",
              total);

      return "purchaseConfirm";
  }
  @PostMapping("/purchase")
public String purchase(
HttpSession session) {

User loginUser =
(User) session.getAttribute(
                "loginUser");

                if (loginUser == null) {

    return "purchaseLogin";
}

        List<CartItem> cart = (List<CartItem>) session.getAttribute(
    "cart");

for (CartItem item : cart) {

  Product product = productRepository.findByProductId(
      item.getProductId());

  if (product.getStock() < item.getQuantity()) {

    return "stockError";
  }
}



Order order = new Order();

order.setUserId(
loginUser.getUserId());

order.setOrderDate(
LocalDateTime.now());

orderRepository.save(order);

for (CartItem item : cart) {

  OrderDetail detail = new OrderDetail();

  detail.setOrderId(
      order.getOrderId());

  detail.setProductId(
      item.getProductId());

  detail.setQuantity(
      item.getQuantity());

  detail.setPrice(
      item.getPrice());

  orderDetailRepository.save(
      detail);

  Product product = productRepository.findByProductId(
      item.getProductId());

  product.setStock(
      product.getStock()
          - item.getQuantity());

  productRepository.save(
      product);
}
session.removeAttribute(
"cart");

return "purchaseComplete";
}

}