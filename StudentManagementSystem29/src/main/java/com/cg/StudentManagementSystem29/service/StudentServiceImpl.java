package com.cg.StudentManagementSystem29.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.StudentManagementSystem29.entity.Student;
import com.cg.StudentManagementSystem29.repo.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository repo;

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		repo.save(student);
		
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}
	
	
	
	

}
