package com.ecsite;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

  @Autowired
  private UserRepository repository;

  @GetMapping("/login")
  public String login() {

    return "login";
  }

  @PostMapping("/login")
  public String loginCheck(
      @RequestParam String loginId,
      @RequestParam String password,
        HttpSession session) {

    User user = repository.findByLoginIdAndPassword(
        loginId,
        password);

    if (user == null) {

      return "loginError";
    }
    session.setAttribute("loginUser", user);

    return "redirect:/EC";
  }
}