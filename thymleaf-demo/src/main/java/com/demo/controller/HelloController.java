package com.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Student;

@Controller
public class HelloController {

	@RequestMapping("/sayhello")
	public String sayHello() {
		return "Hello";
	}

	@GetMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mv = new ModelAndView("data");
		mv.addObject("message", "Sending Object new");
		return mv;
	}

	@GetMapping("/sendObject")
	public ModelAndView sendObject() {
		ModelAndView mv = new ModelAndView("objectTemplate");
		Student student = new Student();
		student.setId(1);
		student.setName("Rahul");
		student.setScore(100);
		mv.addObject("student", student);
		return mv;

	}

	@GetMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView mav = new ModelAndView("students");

		Student student = new Student();
		student.setId(1);
		student.setName("John");
		student.setScore(99);

		Student student2 = new Student();
		student2.setId(1);
		student2.setName("Johny");
		student2.setScore(79);

		List<Student> students = Arrays.asList(student, student2);

		mav.addObject("students", students);

		return mav;
	}

	@GetMapping("/studentform")
	public ModelAndView showStudentForm() {
		ModelAndView mav = new ModelAndView("studentform");

		Student student = new Student();
		student.setId(1);
		student.setName("Bob");
		student.setScore(88);
		mav.addObject(student);

		return mav;
	}

	@GetMapping("/studentsubmissionform")
	public ModelAndView showStudentSubmissionForm() {
		ModelAndView mav = new ModelAndView("studentSubmissionForm");
		return mav;
	}

//	@PostMapping("/saveDetails")
//	public ModelAndView saveStudent(@ModelAttribute Student student) {
//		ModelAndView mav = new ModelAndView("result");
//		System.out.println(student.getId());
//		System.out.println(student.getName());
//		System.out.println(student.getScore());
//
//		mav.addObject(student);
//
//		return mav;
//	}

	@PostMapping("/saveDetails")
	public ModelAndView saveDetails(@RequestParam int id,@RequestParam String name, @RequestParam int score) {
		// Process and store the form data

		Student student=new Student();
		student.setId(id);
		student.setName(name);
		
		ModelAndView mv =  new ModelAndView("result");
		mv.addObject(student);
		// Redirect to a confirmation page
		return mv;
	}

}
