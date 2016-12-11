/**
 * 
 */
package com.spring.rest.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author Krishna
 *
 */
public class SpringRestTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/restsupport";

	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllCustomers() {
		System.out.println("Testing listAllUsers API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> customersMap = restTemplate.getForObject(REST_SERVICE_URI + "/courses",
				List.class);

		if (customersMap != null) {
			for (LinkedHashMap<String, Object> map : customersMap) {
				System.out.println("User : Course Name=" + map.get("courseName") + ", Score=" + map.get("score"));
				;
			}
		} else {
			System.out.println("No courses exist----------");
		}
	}

	public static void main(String args[]) {
		listAllCustomers();
	}
}
