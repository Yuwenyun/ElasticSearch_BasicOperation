package com.owen.ElasticSearch_BasicOperation;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.owen.metadata.Employee;
import com.owen.metadata.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class AppTest
{
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ElasticsearchTemplate template;
    
    @Before
    public void before()
    {
    	template.deleteIndex(Employee.class);
    	template.createIndex(Employee.class);
    	template.putMapping(Employee.class);
    	template.refresh(Employee.class);
    }
    
    @Test
    public void testSave()
    {
    	List<String> interests = new ArrayList<String>();
    	interests.add("guitar");
    	interests.add("english");
    	Employee employee = new Employee("10001", "Owen", "Lee", 24, true, interests);
    	
    	Employee emp = employeeService.save(employee);
    	assertNotNull(emp);
    }
}
