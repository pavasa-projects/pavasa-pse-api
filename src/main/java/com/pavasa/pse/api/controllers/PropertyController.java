package com.pavasa.pse.api.controllers;

import com.pavasa.pse.api.models.Property;
import com.pavasa.pse.api.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/property")
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping(value = "/{propertyId}")
    public ResponseEntity getProperty(@PathVariable(value = "propertyId") String propertyId) {
        HashMap<String, Object> result = new HashMap<>();
        Property property = propertyService.getProperty(propertyId);
        if (property == null) {
            result.put("error", "Not found");
            return ResponseEntity.badRequest().body(result);
        }

        return ResponseEntity.ok(property);
    }

    @GetMapping
    public ResponseEntity getProperties() {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<Property> properties = propertyService.getProperties();
            if (properties.size() != 0) {
                return ResponseEntity.ok(properties);
            }

        } catch (Exception ignored) {

        }
        result.put("error", "No properties found");
        return ResponseEntity.badRequest().body(result);

    }


    @PostMapping
    public ResponseEntity addOrUpdateProperty(@RequestBody Property property) {
        try {
            final Property insertedProperty = propertyService.addOrUpdateProperty(property);

            if (insertedProperty.getId() != null) {
                return ResponseEntity.ok(insertedProperty);
            }
        } catch (Exception ignored) {

        }
        final HashMap<String, Object> result = new HashMap<>();
        result.put("errorMsg", "There is some technical error, please try again");
        return ResponseEntity.badRequest().body(result);
    }


}
