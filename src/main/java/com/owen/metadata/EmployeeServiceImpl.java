package com.owen.metadata;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeRepository employeeRepository;
	public void setEmployeeRepository(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee save(Employee employee)
	{
		return this.employeeRepository.save(employee);
	}

	@Override
	public void delete(Employee employee)
	{
		this.employeeRepository.delete(employee);
	}

	@Override
	public Employee findOne(String id)
	{
		return this.employeeRepository.findOne(id);
	}

	@Override
	public Iterable<Employee> findAll()
	{
		return this.employeeRepository.findAll();
	}

	@Override
	public Page<Employee> findByFirstName(String first_name, PageRequest pageRequest)
	{
		return this.employeeRepository.findByFirstName(first_name, pageRequest);
	}

	@Override
	public List<Employee> findByLastName(String last_name)
	{
		return this.employeeRepository.findByLastName(last_name);
	}
}
