package com.ecsite;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderDetailController {
  @Autowired
  private OrderDetailRepository repository;
  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/orderDetail")
  public String orderDetail(@RequestParam Integer orderId, Model model) {
    List<OrderDetail> details = repository.findByOrderId(orderId);
int total = 0;

for (OrderDetail detail : details) {

    Product product = productRepository.findByProductId(
        detail.getProductId());

    if (product != null) {

        detail.setProductName(
            product.getProductName());
    }

    total += detail.getPrice()
            * detail.getQuantity();
}
    model.addAttribute("details", details);
    model.addAttribute("orderId", orderId);
    model.addAttribute("total", total);
    return "orderDetail";
  }

}
