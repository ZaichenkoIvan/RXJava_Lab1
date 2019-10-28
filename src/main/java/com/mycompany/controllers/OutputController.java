package com.mycompany.controllers;

import com.mycompany.model.entity.NotebookEntity;
import com.mycompany.model.services.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/output")
public class OutputController {
    @Autowired
    private OutputService outputService;
    private UUID uuid;

    @GetMapping("/thread")
    public Map<String, ?> addNotebook(@RequestParam("number") int number) {
        Map<String, Object> modelMap = new HashMap<>();
        List<NotebookEntity> entries = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            uuid = UUID.randomUUID();
            entries.add(new NotebookEntity(uuid.toString(), uuid.hashCode()));
        }
        outputService.addNotebook(entries);

        return modelMap;
    }
}
