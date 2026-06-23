package com.ecsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

  @Autowired
  private UserRepository repository;

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(
      @RequestParam String loginId,
      @RequestParam String password,
      @RequestParam String userName) {

    User user = new User();

    user.setLoginId(loginId);
    user.setPassword(password);
    user.setUserName(userName);

    repository.save(user);

    return "redirect:/registerSuccess";
  }
  @GetMapping("/registerSuccess")
  public String registerSuccess() {
    return "registerSuccess";
  }
}
