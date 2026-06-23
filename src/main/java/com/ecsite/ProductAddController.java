package com.ecsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductAddController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/admin/product/add")
  public String addForm() {

    return "productAdd";
  }

  @PostMapping("/admin/product/add")
  public String add(
      @RequestParam String productId,
      @RequestParam String productName,
      @RequestParam Integer price,
      @RequestParam Integer stock,
      @RequestParam MultipartFile image)
      throws Exception {

    Product product = new Product();

    product.setProductId(productId);
    product.setProductName(productName);
    product.setPrice(price);
    product.setStock(stock);

    product.setActive(true);

    product.setImageData(
        image.getBytes());

    productRepository.save(product);

    return "redirect:/admin";
}

}
