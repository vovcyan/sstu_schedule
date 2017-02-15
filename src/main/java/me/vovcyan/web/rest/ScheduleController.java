package me.vovcyan.web.rest;

import me.vovcyan.model.Faculty;
import me.vovcyan.model.Group;
import me.vovcyan.service.LocalStorage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import me.vovcyan.parser.ParserSSU;

@RestController
public class ScheduleController {

    @Autowired
    private ParserSSU parserSSU;

    @RequestMapping("/get_faculties")
    public String getFaculties(){
        LocalStorage storage = parserSSU.getStorage();
        Collection<Faculty> faculties = storage.getFaculties();

        JSONObject response = new JSONObject();
        JSONArray array = new JSONArray();

        try {
            for (Faculty faculty : faculties) {
                JSONObject facultyItem = new JSONObject();
                facultyItem.put("faculty_name", faculty.getName());
                facultyItem.put("faculty_id", faculty.getUniversity() + "_" + faculty.getId());
                array.put(facultyItem);
            }
            response.put("faculties", array);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    @RequestMapping("/get_groups")
    public String getGroups(@RequestParam("faculty_id") String faculty_id){
        LocalStorage storage = parserSSU.getStorage();
        Faculty faculty = storage.getFacultyById(faculty_id);
        Collection<Group> groups = faculty.getGroups();

        JSONObject response = new JSONObject();
        JSONArray jsonGroups = new JSONArray();

        try {
            for (Group group : groups) {
                JSONObject obj = new JSONObject();

                obj.put("group_name", group.getName());
                obj.put("group_id", group.getId());

                jsonGroups.put(obj);
            }

            response.put("groups", jsonGroups);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    @RequestMapping("/get_schedule")
    public String getSchedule(@RequestParam("group_id") String group_id) {
        LocalStorage storage = parserSSU.getStorage();
        String faculty_id = group_id.substring(0, group_id.length() - 4);
        Faculty faculty = storage.getFacultyById(faculty_id);
        Group group = faculty.getGroup(group_id);

        JSONObject response = new JSONObject();

        try {
            response = group.toJSON();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response.toString();
    }
}
