package com.example.jdata3_2.Controller;

import com.example.jdata3_2.Service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/fetch-product")
    public String fetchProductByName(@RequestParam String name){
        return service.fetchProductByName(name);
    };

}
