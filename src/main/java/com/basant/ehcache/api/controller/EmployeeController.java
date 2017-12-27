package com.basant.ehcache.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basant.ehcache.api.model.Employee;
import com.basant.ehcache.api.service.EmployeeService;

@RestController
@RequestMapping("/ehcache-example")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/loadAll")
	public List<Employee> getAll() {
		return service.getAll();
	}

	@GetMapping("/search/{name}")
	public Employee findEmployeeByName(@PathVariable String name) {
		return service.searchEmployeeByName(name);
	}

}
