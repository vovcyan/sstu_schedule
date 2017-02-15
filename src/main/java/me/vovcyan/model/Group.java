package me.vovcyan.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Group {
    private String id = "";
    private String name = "";
    private ArrayList<Day> days = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDays(ArrayList<Day> days) {
        this.days = days;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject obj = new JSONObject();
        JSONArray jsonDays = new JSONArray();

        for (Day day : days) {
            jsonDays.put(day.toJSON());
        }

        obj.put("group_name", name);
        obj.put("days", jsonDays);

        return obj;
    }
}
