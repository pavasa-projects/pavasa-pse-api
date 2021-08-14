package com.pavasa.pse.api.services;

import com.pavasa.pse.api.daos.PropertyDao;
import com.pavasa.pse.api.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    private PropertyDao propertyDao;

    public Property getProperty(String id) {

        Property property = propertyDao.getProperty(id);
        if (property.getId() == null || property.getId().isEmpty()) {
            return null;
        }
        return property;
    }

    public String addProperty(Property property){
        return propertyDao.addProperty(property);
    }

    public Boolean updateProperty(Property property){
        return propertyDao.updateProperty(property);
    }
}
