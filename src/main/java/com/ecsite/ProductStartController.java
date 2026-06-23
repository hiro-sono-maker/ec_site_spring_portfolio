package com.ecsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductStartController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/admin/product/start")
  public String start(
      @RequestParam String productId) {

    Product product = productRepository.findByProductId(
        productId);

    product.setActive(true);

    productRepository.save(product);

    return "redirect:/admin/product/list";
  }

}
