package com.pavasa.pse.api.controllers;

import com.pavasa.pse.api.models.Property;
import com.pavasa.pse.api.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/v1/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping(value = "id/{propertyId}")
    public ResponseEntity getProperty(@PathVariable(value = "propertyId") String propertyId) {
        HashMap<String, Object> result = new HashMap<>();
        Property property = propertyService.getProperty(propertyId);
        if (property == null) {
            result.put("error", "Not found");
            return ResponseEntity.badRequest().body(result);
        }

        result.put("property", property);
        result.put("api", "java");

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity addProperty(@RequestBody Property property){
        return ResponseEntity.ok(propertyService.addProperty(property));
    }

    @PutMapping
    public ResponseEntity updateProperty(@RequestBody Property property){
        return ResponseEntity.ok(propertyService.updateProperty(property));
    }

}
