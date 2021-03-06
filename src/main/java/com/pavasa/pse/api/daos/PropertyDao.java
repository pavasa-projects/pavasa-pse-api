package com.pavasa.pse.api.daos;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.pavasa.pse.api.models.Property;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class PropertyDao extends AbstractPSEDao {

    private final MongoCollection<Property> propertiesCollection;

    @Autowired
    protected PropertyDao(MongoClient mongoClient, @Value("${spring.mongodb.database}") String databaseName) {
        super(mongoClient, databaseName);
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        String COLLECTION_NAME = "properties";
        this.propertiesCollection = db.getCollection(COLLECTION_NAME, Property.class).withCodecRegistry(pojoCodecRegistry);
    }

    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<Property>();
        propertiesCollection.find().iterator().forEachRemaining(properties :: add);
        return properties;
    }

    public Property getProperty(String id) {
        Bson filter = eq("_id", new ObjectId(id));
        return propertiesCollection.find(filter).first();
    }

    public Property addOrUpdateProperty(Property property) {
        // for update property
        if (property.getId() != null) {
            return updateProperty(property);
        }
        return addProperty(property);
    }

    private Property addProperty(Property property) {
        InsertOneResult result = propertiesCollection.insertOne(property);
        if (result.wasAcknowledged()) {
            property.setOid(result.getInsertedId().asObjectId().getValue());
        }
        return property;
    }

    private Property updateProperty(Property property) {
        propertiesCollection.replaceOne(Filters.eq("_id", new ObjectId(property.getId())), property);
        return property;
    }

    private boolean validIdValue(String movieId) {
        //TODO> Ticket: Handling Errors - implement a way to catch a
        //any potential exceptions thrown while validating a movie id.
        //Check out this method's use in the method that follows.
        return true;
    }


}
