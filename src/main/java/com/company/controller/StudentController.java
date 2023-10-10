package com.company.controller;

import com.company.entity.Student;
import com.company.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student_redis")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public Student post(@RequestBody Student dto) {
        return studentService.create(dto);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable("id") String id) {
        return studentService.get(id);
    }

    @GetMapping("")
    public List<Student> all() {
        return studentService.all();
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable("id") String id, @RequestBody Student dto) {
        return studentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        studentService.delete(id);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        studentService.deleteAll();
    }

}
