package com.pavasa.pse.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

import java.util.List;

public class Property {

    @JsonProperty("_id")
    @BsonIgnore
    private String id;

    @BsonId
    @JsonIgnore
    private ObjectId oid;

    // location
    private String propertyLocation;
    private double lat;
    private double lng;
    private String societyName;

    // property details
    private String subTypeOfProperty;

    // TODO make this as string to handle 5+
    private int noOfBedrooms;
    private int noOfBalconies;
    private int noOfBathrooms;
    private String floorNo;
    private int totalFloors;
    private int noOfCoveredParking;
    private int noOfOpenParking;

    // rent details
    private int monthlyRent;
    private int securityAmount;
    private int maintenanceCharges;

    // more property details
    private int carpetArea;
    private String preferredTenantType;
    private String furnishingStatus;
    private List<String> furnishingDetails;
    private List<String> amenities;
    // TODO : available from

    // TODO : property photos

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

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getSubTypeOfProperty() {
        return subTypeOfProperty;
    }

    public void setSubTypeOfProperty(String subTypeOfProperty) {
        this.subTypeOfProperty = subTypeOfProperty;
    }

    public int getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public int getNoOfBalconies() {
        return noOfBalconies;
    }

    public void setNoOfBalconies(int noOfBalconies) {
        this.noOfBalconies = noOfBalconies;
    }

    public int getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(int noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public int getNoOfCoveredParking() {
        return noOfCoveredParking;
    }

    public void setNoOfCoveredParking(int noOfCoveredParking) {
        this.noOfCoveredParking = noOfCoveredParking;
    }

    public int getNoOfOpenParking() {
        return noOfOpenParking;
    }

    public void setNoOfOpenParking(int noOfOpenParking) {
        this.noOfOpenParking = noOfOpenParking;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public int getSecurityAmount() {
        return securityAmount;
    }

    public void setSecurityAmount(int securityAmount) {
        this.securityAmount = securityAmount;
    }

    public int getMaintenanceCharges() {
        return maintenanceCharges;
    }

    public void setMaintenanceCharges(int maintenanceCharges) {
        this.maintenanceCharges = maintenanceCharges;
    }

    public int getCarpetArea() {
        return carpetArea;
    }

    public void setCarpetArea(int carpetArea) {
        this.carpetArea = carpetArea;
    }

    public String getPreferredTenantType() {
        return preferredTenantType;
    }

    public void setPreferredTenantType(String preferredTenantType) {
        this.preferredTenantType = preferredTenantType;
    }

    public String getFurnishingStatus() {
        return furnishingStatus;
    }

    public void setFurnishingStatus(String furnishingStatus) {
        this.furnishingStatus = furnishingStatus;
    }

    public List<String> getFurnishingDetails() {
        return furnishingDetails;
    }

    public void setFurnishingDetails(List<String> furnishingDetails) {
        this.furnishingDetails = furnishingDetails;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}
