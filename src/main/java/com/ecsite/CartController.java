package com.ecsite;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping("/cart/add")
  public String addCart(
      @RequestParam String productId,
      HttpSession session) {

    Product product = productRepository.findByProductId(
        productId);

    List<CartItem> cart = (List<CartItem>) session.getAttribute(
        "cart");

    if (cart == null) {
      cart = new ArrayList<>();
    }

    CartItem item = new CartItem();

    item.setProductId(
        product.getProductId());

    item.setProductName(
        product.getProductName());

    item.setPrice(
        product.getPrice());

    item.setQuantity(1);

    item.setImageData(
            product.getImageData());

    cart.add(item);

    session.setAttribute(
        "cart",
        cart);

    return "redirect:/EC";
  }

  @GetMapping("/cart")
  public String cart(
      HttpSession session,
          Model model) {

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

      return "cart";
  }

  @PostMapping("/cart/plus")
public String plus(
        @RequestParam Integer index,
        HttpSession session) {

    List<CartItem> cart =
        (List<CartItem>) session.getAttribute(
            "cart");

    CartItem item = cart.get(index);

    item.setQuantity(
        item.getQuantity() + 1);

    session.setAttribute(
        "cart",
        cart);

    return "redirect:/cart";
}

 @PostMapping("/cart/minus")
public String minus(
        @RequestParam Integer index,
        HttpSession session) {

    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

    if (cart != null && index < cart.size()) {
        CartItem item = cart.get(index);

        if (item.getQuantity() > 1) {
            // 2個以上なら1個減らす
            item.setQuantity(item.getQuantity() - 1);
        } else {
            // 1個のときにマイナスが押されたら、リストから削除する
            cart.remove((int) index);
        }
    }

    session.setAttribute("cart", cart);
    return "redirect:/cart";
}
}