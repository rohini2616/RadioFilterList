package com.example.postservicecars;

import java.util.ArrayList;

public class ResponseLocation {
    private String status;
    private ArrayList<String> locationList;
    private VehicleInfo vehicleInfo;
    private Object vehiclePriceRange;

    public Object getVehiclePriceRange() {
        return vehiclePriceRange;
    }

    public void setVehiclePriceRange(Object vehiclePriceRange) {
        this.vehiclePriceRange = vehiclePriceRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<String> locationList) {
        this.locationList = locationList;
    }

    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(VehicleInfo vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    private class VehicleInfo {
        private String make;
        private String model;
        private String variant;
        private String segment;
        private int year;
        private int movingType;
        private int fuelType;
        private int age;
        private float exShowroomPrice;
        private float onRoadPrice;
        private boolean isDiscontinued;
        private Object vehiclePriceRange;

        public Object getVehiclePriceRange() {
            return vehiclePriceRange;
        }

        public void setVehiclePriceRange(Object vehiclePriceRange) {
            this.vehiclePriceRange = vehiclePriceRange;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getVariant() {
            return variant;
        }

        public void setVariant(String variant) {
            this.variant = variant;
        }

        public String getSegment() {
            return segment;
        }

        public void setSegment(String segment) {
            this.segment = segment;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMovingType() {
            return movingType;
        }

        public void setMovingType(int movingType) {
            this.movingType = movingType;
        }

        public int getFuelType() {
            return fuelType;
        }

        public void setFuelType(int fuelType) {
            this.fuelType = fuelType;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public float getExShowroomPrice() {
            return exShowroomPrice;
        }

        public void setExShowroomPrice(float exShowroomPrice) {
            this.exShowroomPrice = exShowroomPrice;
        }

        public float getOnRoadPrice() {
            return onRoadPrice;
        }

        public void setOnRoadPrice(float onRoadPrice) {
            this.onRoadPrice = onRoadPrice;
        }

        public boolean isDiscontinued() {
            return isDiscontinued;
        }

        public void setDiscontinued(boolean discontinued) {
            isDiscontinued = discontinued;
        }
    }



    }


