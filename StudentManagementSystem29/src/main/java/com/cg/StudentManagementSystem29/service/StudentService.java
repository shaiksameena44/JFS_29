package com.cg.StudentManagementSystem29.service;

import java.util.List;

import com.cg.StudentManagementSystem29.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(Long id);
	public void saveStudent(Student student);
	public void deleteStudent(Long id);

}
