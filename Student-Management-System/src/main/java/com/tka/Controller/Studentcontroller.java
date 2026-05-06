package com.tka.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Student;
import com.tka.repo.StudentRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/students")
 


public class Studentcontroller {

	
	 @Autowired
	    private StudentRepository repo;

	    @PostMapping
	    public Student addStudent(@RequestBody Student student) {
	        return repo.save(student);
	    }

	    @GetMapping
	    public List<Student> getAll() {
	        return repo.findAll();
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        repo.deleteById(id);
	    }
	}



