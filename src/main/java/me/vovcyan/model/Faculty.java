package me.vovcyan.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Document(collection = "faculties")
public class Faculty {

    @Id
    private String id;

    private String name;
    private String university;
    HashMap<String, Group> groups = new HashMap<>();

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getUniversity() {
        return university;
    }

    public Collection<Group> getGroups() {
        return groups.values();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setGroups(ArrayList<Group> groups) {
        for (Group group : groups) {
            this.groups.put(group.getId(), group);
        }
    }

    public Group getGroup(String id){
        return groups.get(id);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject obj = new JSONObject();
        JSONArray jsonGroup = new JSONArray();

        for (Group group : groups.values()) {
            jsonGroup.put(group.toJSON());
        }

        obj.put("faculty_name", university + "_" + id);
        obj.put("groups", groups);

        return obj;
    }
}
