package com.ecsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductStopController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/admin/product/stop")
  public String delete(
      @RequestParam String productId) {

    Product product = productRepository.findByProductId(
        productId);

    product.setActive(false);

    productRepository.save(
        product);

    return "redirect:/admin/product/list";

  }
}