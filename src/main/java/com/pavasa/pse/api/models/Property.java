package com.pavasa.pse.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

public class Property {

    @JsonProperty("_id")
    @BsonIgnore
    private String id;

    @BsonId
    @JsonIgnore
    private ObjectId oid;

    private String name;
    private String area;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.oid = new ObjectId(id);
    }

    public ObjectId getOid() {
        return oid;
    }

    public void setOid(ObjectId oid) {
        this.oid = oid;
        this.id = oid.toHexString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
