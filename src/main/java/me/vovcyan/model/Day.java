package me.vovcyan.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Day {
    private String id = "";
    private ArrayList<Lesson> lessons = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject obj = new JSONObject();
        JSONArray jsonLessons = new JSONArray();

        for (Lesson lesson : lessons) {
            jsonLessons.put(lesson.toJSON());
        }

        obj.put("weekday", id);
        obj.put("lessons", jsonLessons);

        return obj;
    }
}
