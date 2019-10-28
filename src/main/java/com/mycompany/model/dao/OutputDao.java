package com.mycompany.model.dao;

import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.mycompany.model.entity.NotebookEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class OutputDao extends AbstractDao {
    public void addNotebook(NotebookEntity notebook){
        Map<String, Object> json = new HashMap<>();
        json.put("brand", notebook.getBrand());
        json.put("serialNumber", notebook.getSerialNumber());
        JsonDocument document = JsonDocument.create(UUID.randomUUID().toString(), JsonObject.from(json));
        this.notebooks.insert(document);
    }
}
