package com.cg.StudentManagementSystem29.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cg.StudentManagementSystem29.entity.Student;
import com.cg.StudentManagementSystem29.service.StudentService;


@Controller
@RequestMapping("/students") // Base path for all routes
public class StudentController {

    @Autowired
    private StudentService service;

    // 1. Show list of students
    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", service.getAllStudents());
        return "index";
    }

    // 2. Show form to create new student
    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    // 3. Save new student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    // 4. Show form to edit student
    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "edit";
    }

    // 5. Update student
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        Student existing = service.getStudentById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setDepartment(student.getDepartment());
        service.saveStudent(existing);
        return "redirect:/students";
    }

    // 6. Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}



