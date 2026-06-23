package com.ecsite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminLogoutController {

  @GetMapping("/admin/logout")
  public String logout(
      HttpSession session) {

    session.removeAttribute(
        "adminLogin");

    return "redirect:/EC";
  }

}
