package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(int id);

	public Student updateStudent(Student student, int id);

	public void deleteStudent(int id);
}
