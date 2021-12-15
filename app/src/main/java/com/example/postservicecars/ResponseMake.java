package com.example.postservicecars;

import java.util.ArrayList;

public class ResponseMake {
    private  String status;
    private ArrayList<String> makeList;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getMakeList() {
        return makeList;
    }

    public void setMakeList(ArrayList<String> makeList) {
        this.makeList = makeList;
    }


}
