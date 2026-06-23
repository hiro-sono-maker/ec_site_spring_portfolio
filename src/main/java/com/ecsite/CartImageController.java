package com.ecsite;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartImageController {

  @GetMapping("/cart/image/{index}")
  @ResponseBody
  public ResponseEntity<byte[]> image(
      @PathVariable Integer index,
      HttpSession session) {

    List<CartItem> cart = (List<CartItem>) session.getAttribute(
        "cart");

    if (cart == null
        || index >= cart.size()) {

      return ResponseEntity.notFound()
          .build();
    }

    CartItem item = cart.get(index);

    if (item.getImageData() == null) {

      return ResponseEntity.notFound()
          .build();
    }

    return ResponseEntity.ok()
        .contentType(
            MediaType.IMAGE_JPEG)
        .body(
            item.getImageData());
  }

}
