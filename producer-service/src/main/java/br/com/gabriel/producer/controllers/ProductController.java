package br.com.gabriel.producer.controllers;

import br.com.gabriel.producer.dtos.ProductDTO;
import br.com.gabriel.producer.services.ProductService;
import br.com.gabriel.producer.services.StringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> produces(@RequestBody ProductDTO dto) {
        service.createProduct(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
