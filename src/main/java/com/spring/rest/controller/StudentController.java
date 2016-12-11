/**
 * 
 */
package com.spring.rest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.model.Course;
import com.spring.rest.model.Student;

/**
 * @author Krishna
 *
 */
@RestController
public class StudentController {

	
	//@RequestMapping(value = "properties", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.GET)
	
	
	
	@ResponseBody
    @RequestMapping(value = "/getstudent/{id}/{name}",
        method = RequestMethod.GET,
        produces={"application/json", "application/xml"})
    public ResponseEntity<Student> getStudent(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("id") final int id,
            @PathVariable("name") final String name) {
        
        // Create a new student object and return it
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Student student = new Student(id, name, dateFormatter.format(new Date()));
        
        List<Course> cources = student.getCourses();
        cources.add(new Course("Math", 20));
        cources.add(new Course("Politics", 10));
        
        //return student;
        
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }	
	
	
	@GetMapping("/courses")
	public ResponseEntity<Course> getCourses() {

		List<Course> lc = new ArrayList<Course>();
		
		Course course = new Course();
		course.setCourseName("test");
		course.setScore(10);
		lc.add(course);

		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
}
