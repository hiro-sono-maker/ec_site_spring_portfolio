package com.ecsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ImageController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/image/{productId}")
    @ResponseBody
    public ResponseEntity<byte[]> image(
            @PathVariable String productId) {

        Product product = repository.findByProductId(
                productId);

        if (product == null
                || product.getImageData() == null) {

            return ResponseEntity.notFound()
                    .build();
        }

        return ResponseEntity.ok()
                .contentType(
                        MediaType.IMAGE_JPEG)
                .body(
                        product.getImageData());

    }
}