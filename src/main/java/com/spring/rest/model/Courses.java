/**
 * 
 */
package com.spring.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * @author Krishna
 *
 */

@XmlRootElement(name = "courses")
@XmlType(propOrder = { "courses"})
@JsonPropertyOrder({ "courses"})
public class Courses implements Serializable {
	private static final long serialVersionUID = 1L;
	
	List<Course> courses = new ArrayList<Course>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}	
}
