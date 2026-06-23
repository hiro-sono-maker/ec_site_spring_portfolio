package com.ecsite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HistoryController {

  @Autowired
  private OrderRepository repository;

  @GetMapping("/history")
  public String history(
      HttpSession session,
      Model model) {

    User loginUser = (User) session.getAttribute(
        "loginUser");

    if (loginUser == null) {

      return "redirect:/login";
    }

    List<Order> orders = repository.findByUserId(
        loginUser.getUserId());

    model.addAttribute(
        "orders",
        orders);

    return "history";
  }
}
