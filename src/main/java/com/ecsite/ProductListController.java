package com.ecsite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductListController {

  @Autowired
  private ProductRepository productRepository;

@GetMapping("/admin/product/list")
public String list(Model model) {

    List<Product> products =
            productRepository.findAll();

    model.addAttribute(
            "products",
            products);

    return "productList";
}

}
