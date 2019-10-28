package com.mycompany.controllers;

import com.mycompany.model.services.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/input")
public class InputController {
    @Autowired
    private InputService inputService;

    @GetMapping("/rxjava")
    public Map<String, ?> getWithRXJava() {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("data", inputService.getAllNotebooks());

        return modelMap;
    }
}
