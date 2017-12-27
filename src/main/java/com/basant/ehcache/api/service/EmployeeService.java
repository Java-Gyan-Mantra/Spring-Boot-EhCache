package com.basant.ehcache.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.basant.ehcache.api.model.Employee;
import com.basant.ehcache.api.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	private static int requestHit = 0;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@PostConstruct
	public void loadRecords2DB() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 1; i <= 1000; i++) {
			employees.add(new Employee(i, "name" + i, "dept" + i, i * 10));
		}
		repository.save(employees);
		logger.info("Totla number of record stored while start up application {}", employees.size());
	}

	@Cacheable(value = "usersCache")
	public List<Employee> getAll() {
		requestHit++;
		logger.info("Hiting DB TO fetch all record in request hit {}", requestHit);
		return repository.findAll();
	}

	@Cacheable(value = "usersCache", key = "#name")
	public Employee searchEmployeeByName(String name) {
		requestHit++;
		logger.info("Hiting DB TO fetch  record with name {} in request hit {}", name, requestHit);
		return repository.findByName(name);
	}
}
