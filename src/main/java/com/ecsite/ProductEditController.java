package com.ecsite;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class ProductEditController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/admin/product/edit")
  public String editForm(
      @RequestParam String productId,
      Model model) {

    Product product = productRepository.findByProductId(
        productId);

    model.addAttribute(
        "product",
        product);

    return "productEdit";
  }

@PostMapping("/admin/product/edit")
public String edit(
        @RequestParam String productId,
        @RequestParam String productName,
        @RequestParam Integer price,
                @RequestParam Integer stock,
                @RequestParam MultipartFile image)
                throws Exception {

    Product product =
            productRepository.findByProductId(
                    productId);

    product.setProductName(
            productName);

    product.setPrice(
            price);

    product.setStock(
                    stock);
    if (!image.isEmpty()) {

            product.setImageData(
                            image.getBytes());
    }


    productRepository.save(
            product);

    return "redirect:/admin/product/list";
}

}
