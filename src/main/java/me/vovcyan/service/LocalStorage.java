package me.vovcyan.service;

import me.vovcyan.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class LocalStorage {
    HashMap<String, Faculty> faculties = new HashMap<>();

    public void setFaculties(ArrayList<Faculty> faculties) {
        faculties.forEach(this::setFaculty);
    }

    public void setFaculty(Faculty faculty) {
        this.faculties.put(faculty.getUniversity() + "_" + faculty.getId(), faculty);
    }

    public Collection<Faculty> getFaculties() {
        return faculties.values();
    }

    public Faculty getFacultyById(String id) {
        return faculties.get(id);
    }
}
