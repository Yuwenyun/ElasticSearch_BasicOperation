package com.owen.metadata;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String>
{
	Page<Employee> findByFirstName(String first_name, Pageable pageable);
    List<Employee> findByLastName(String last_name);
}
