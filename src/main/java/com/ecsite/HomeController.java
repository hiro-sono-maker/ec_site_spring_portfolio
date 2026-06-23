package com.ecsite;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
  @Autowired
  private ProductRepository repository;

@GetMapping("/EC")
public String index(
@RequestParam(required = false)
String keyword,

    Model model,

    HttpSession session) {

  List<Product> products;

  if (keyword == null
      || keyword.isEmpty()) {

    products = repository.findByActiveTrue();

  } else {

    products = repository
        .findByProductNameContainingAndActiveTrue(
            keyword);
  }

  model.addAttribute(
      "products",
      products);

  model.addAttribute(
      "keyword",
      keyword);

  User loginUser = (User) session.getAttribute(
          "loginUser");

  model.addAttribute(
          "loginUser",
          loginUser);

  List<CartItem> cart = (List<CartItem>) session.getAttribute(
          "cart");

  int cartCount = 0;

  if (cart != null) {

      for (CartItem item : cart) {

          cartCount += item.getQuantity();
      }
  }
  model.addAttribute(
          "cartCount",
          cartCount);

  return "index";
}
}
