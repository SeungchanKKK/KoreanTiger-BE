package com.geupjo.koreantiger.controller.hello;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Tiger API v1", description = "Tiger v1 Controller")
@RequestMapping("/v1")
@RestController
public class TigerHelloController {
    @Operation(summary = "Swagger tiger API hello")
    @GetMapping("/tiger")
    public ResponseEntity<String> hello(@Parameter(description = "이름") @RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.ok("Hello, " + name + "!");
    }
}
