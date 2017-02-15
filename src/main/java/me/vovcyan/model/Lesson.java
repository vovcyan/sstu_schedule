package me.vovcyan.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Lesson {
    private int type = 2;
    private int parity = 0;
    private String id = "";
    private String title = "";
    private String timeStart = "";
    private String timeEnd = "";
    private Teacher teacher = null;
    private Auditory auditory = null;

    public void setType(int type) {
        this.type = type;
    }

    public void setParity(int parity) {
        this.parity = parity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimeStart(String time_start) {
        this.timeStart = time_start;
    }

    public void setTimeEnd(String time_end) {
        this.timeEnd = time_end;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setAuditory(Auditory auditory) {
        this.auditory = auditory;
    }

    public int getType() {
        return type;
    }

    public int getParity() {
        return parity;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Auditory getAuditory() {
        return auditory;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject obj = new JSONObject();

        //obj.put("id", id);

        obj.put("subject", title);
        obj.put("type", type);
        obj.put("time_start", timeStart);
        obj.put("time_end", timeEnd);
        obj.put("parity", parity);

        JSONArray teacherJSON = new JSONArray();
        teacherJSON.put(teacher.toJSON());
        obj.put("teachers", teacherJSON);

        JSONArray auditoryJSON = new JSONArray();
        auditoryJSON.put(auditory.toJSON());
        obj.put("auditories", auditoryJSON);

        return obj;
    }
}
