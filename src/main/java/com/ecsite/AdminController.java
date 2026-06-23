package com.ecsite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin(
            HttpSession session) {

        Boolean adminLogin = (Boolean) session.getAttribute(
                "adminLogin");

        if (adminLogin == null
                || !adminLogin) {
            return "redirect:/admin/login";
        }

        return "admin";
    }

}
