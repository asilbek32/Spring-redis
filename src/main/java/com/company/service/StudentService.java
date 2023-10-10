package com.company.service;

import com.company.entity.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final String studentHash = "student";

    // 'redisTemplate' is defined as a Bean in AppConfig.java
//    @Resource(name = "redisTemplate")
//    private HashOperations<String, Integer, Object> hashOperations;

    //    @Autowired
    private RedisTemplate<String, Object> template;


    public Student create(Student student) {
        student.setId(UUID.randomUUID().toString());
        template.opsForHash().put(studentHash, student.getId(), student);
        return student;
    }

    public Student get(String id) {
        Student student = (Student) template.opsForHash().get(studentHash, id);
        return student;
    }

    public Student update(String id, Student dto) {
        Student student = (Student) template.opsForHash().get(studentHash, id);
        student.setName(dto.getName());
        student.setSurname(dto.getSurname());

        template.opsForHash().put(studentHash, id, dto);
        return student;
    }

    public List<Student> all() {
        List<Student> values = template.opsForHash().values(studentHash).stream().map(o -> {
            return (Student) o;
        }).collect(Collectors.toList());
        return values;
    }


    public void delete(Integer id) {
        template.opsForHash().delete(studentHash, id);
    }

    public void deleteAll() {
        template.delete(studentHash);
    }
}
