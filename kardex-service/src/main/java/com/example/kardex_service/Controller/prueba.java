package com.example.kardex_service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class prueba {

    @GetMapping
    public String health() {
        return "kardex-service OK";
    }
}
