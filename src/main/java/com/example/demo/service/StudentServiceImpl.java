package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
//		Optional<Student> student = studentRepository.findById(id);
//		if (student.isPresent()) {
//			return student.get();
//		} else {
//			throw new ResourceNotFoundException("Student", "ID", id);
//		}

		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));
	}

	@Override
	public Student updateStudent(Student student, int id) {

		// we need to check whether student with given id is exist in DB or not

		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		// save existingStudent to DB

		studentRepository.save(existingStudent);
		return existingStudent;

	}

	@Override
	public void deleteStudent(int id) {

		// we need to check whether student with given id is exist in DB or not

		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));

		studentRepository.deleteById(id);

	}

}
