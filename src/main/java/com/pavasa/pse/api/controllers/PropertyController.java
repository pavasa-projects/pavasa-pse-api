package com.pavasa.pse.api.controller;

import com.pavasa.pse.api.model.Property;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/property")
public class PropertyController {

    @GetMapping(value = "id/{propertyId}")
    public ResponseEntity getProperty(@PathVariable(value = "propertyId") String propertyId) {
        Property property = new Property();
        property.setId("223332");
        return ResponseEntity.ok(property);
    }

    @GetMapping
    public ResponseEntity getProperties(){
        Property property = new Property();
        property.setId("1111");
        return ResponseEntity.ok(property);
    }

}
