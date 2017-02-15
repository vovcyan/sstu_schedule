package me.vovcyan.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Auditory {
    private String name = "";
    private String address = "";

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("auditory_name", name);
        obj.put("auditory_address", address);
        return obj;
    }
}
