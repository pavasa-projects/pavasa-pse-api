package com.pavasa.pse.api.services;

import com.pavasa.pse.api.daos.PropertyDao;
import com.pavasa.pse.api.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Property addOrUpdateProperty(Property property){
        return propertyDao.addOrUpdateProperty(property);
    }

    public List<Property> getProperties(){
        return propertyDao.getProperties();
    }

}
