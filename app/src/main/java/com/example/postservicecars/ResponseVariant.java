package com.example.postservicecars;

import java.util.ArrayList;

public class ResponseVariant {
    private  String status;
    private ArrayList<String> variantList;
    private VehicleInfo vehicleInfo;

    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(VehicleInfo vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getVariantList() {
        return variantList;
    }

    public void setVariantList(ArrayList<String> variantList) {
        this.variantList = variantList;
    }



    private class VehicleInfo {
        private String segment;

        public String getSegment() {
            return segment;
        }

        public void setSegment(String segment) {
            this.segment = segment;
        }

        @Override
        public String toString() {
            return "VehicleInfo{" +
                    "segment='" + segment + '\'' +
                    '}';
        }
    }
}

