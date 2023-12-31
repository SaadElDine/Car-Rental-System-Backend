package com.example.carrentbe.DTO;
public class CarAvailabilityDTO{
    private String plateId;
    private boolean isAvailable;
    // Constructors, getters and setters

    public CarAvailabilityDTO(String plateId, boolean isAvailable) {
        this.plateId = plateId;
        this.isAvailable = isAvailable;
    }

    public String getPlateId() {
        return plateId;
    }

    public void setPlateId(String plateId) {
        this.plateId = plateId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
