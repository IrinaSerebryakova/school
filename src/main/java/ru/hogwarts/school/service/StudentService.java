package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long studentLastId = 0L;

    public Student createStudent(Student student){
        return students.put(++studentLastId, student);
    }
    public Student getStudentById(Long id){
        return students.get(id);
    }

    public Student deleteStudent(Long id){
        return students.remove(id);
    }

    public Student updateStudent(Long id, Student student){
        if(!students.containsKey(id)){
            return null;
        }
        return students.put(id, student);
    }


    public Collection<Student> getStudentsByAge(int age) {
        List<Student> studentsByAge = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }
}
