package com.owen.metadata;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface EmployeeService
{
	Employee save(Employee employee);
	void delete(Employee employee);
	Employee findOne(String id);
	Iterable<Employee> findAll();
	Page<Employee> findByFirstName(String first_name, PageRequest pageRequest);
	List<Employee> findByLastName(String last_name);
}
