package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// build create student REST API
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	// build get all students REST API
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
	}

	// build get student by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}

	// build update student REST API
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}

	// build delete student REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		Set<Integer> set=new HashSet<Integer>();
		return new ResponseEntity<String>("Student deleted successfully...", HttpStatus.OK);
	}

}
