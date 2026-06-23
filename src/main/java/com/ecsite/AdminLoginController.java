package com.ecsite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

  @GetMapping("/admin/login")
  public String loginForm() {

    return "adminLogin";
  }

  @PostMapping("/admin/login")
  public String login(
      String loginId,
      String password,
      HttpSession session) {

    if ("admin".equals(loginId)
        && "admin".equals(password)) {

      session.setAttribute(
          "adminLogin",
          true);

      return "redirect:/admin";
    }

    return "adminLoginError";
  }

}
