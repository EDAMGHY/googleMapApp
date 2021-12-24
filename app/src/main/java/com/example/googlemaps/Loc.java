package com.example.googlemaps;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.Map;


public class Loc {

    private double latitude;
    private double longitude;
    private String createdAt;

    public Loc() {
    }

    public Loc(double latitude, double longitude) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt =  df.format(new Date()).toString();
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Map<String, String> toMap() {
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, String> map = oMapper.convertValue(new Loc(this.latitude, this.longitude), Map.class);
        return map;
    }

    public String toJSON() {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("latitude", this.latitude);
            jsonObject.put("longitude", this.longitude);
            jsonObject.put("createdAt", this.createdAt);

            return jsonObject.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }

    }

    @Override
    public String toString() {
        return "Loc{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", createdAt=" + createdAt +
                '}';
    }
}
