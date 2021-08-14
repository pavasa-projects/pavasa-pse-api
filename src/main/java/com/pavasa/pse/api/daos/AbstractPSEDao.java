package com.pavasa.pse.api.daos;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Configuration
public abstract class AbstractPSEDao {

    protected final String MFLIX_DATABASE;
    protected MongoDatabase db;
    protected MongoClient mongoClient;
    @Value("${spring.mongodb.uri}")
    private String connectionString;

    protected AbstractPSEDao(MongoClient mongoClient, String databaseName) {
        this.mongoClient = mongoClient;
        MFLIX_DATABASE = databaseName;
        this.db = this.mongoClient.getDatabase(MFLIX_DATABASE);
    }

}
