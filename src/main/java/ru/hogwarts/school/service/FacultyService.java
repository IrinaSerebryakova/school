package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private Long facultyLastId = 0L;
    public Faculty createFaculty(Faculty faculty){
        return faculties.put(++facultyLastId, faculty);
    }
    public Faculty getFacultyById(Long id){
        return faculties.get(id);
    }
    public Collection<Faculty> getByColor(String color) {
        List<Faculty> facultiesByColor = new ArrayList<>();
        for (Faculty faculty : faculties.values()) {
            if (faculty.getColor().equals(color)) {
                facultiesByColor.add(faculty);
            }
        }
        return facultiesByColor;
    }
    public Faculty deleteFaculty(Long id){
        return faculties.remove(id);
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        if (!faculties.containsKey(id)) {
          return null;
        }
        return faculties.put(id, faculty);
    }
}
