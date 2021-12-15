package com.example.postservicecars;

import java.util.ArrayList;

public class ResponseModel {
    private  String status;
    private ArrayList<String> modelList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getModelList() {
        return modelList;
    }

    public void setModelList(ArrayList<String> modelList) {
        this.modelList = modelList;
    }
}
