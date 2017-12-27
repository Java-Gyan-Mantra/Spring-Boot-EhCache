package com.basant.ehcache.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basant.ehcache.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByName(String name);
}
