package com.owen.ElasticSearch_BasicOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.owen.metadata.Employee;
import com.owen.metadata.EmployeeService;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private EmployeeService employeeService;

    public static void main(String args[]) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();

        List<String> inter1 = new ArrayList<String>();
    	inter1.add("book");
    	inter1.add("novle");
    	Employee emp1 = new Employee("10002", "John", "Snow", 24, true, inter1);
    	
    	List<String> inter2 = new ArrayList<String>();
    	inter2.add("book");
    	inter2.add("whore");
    	Employee emp2 = new Employee("10003", "Tyrian", "Lannister", 34, true, inter2);
    	
    	List<String> inter3 = new ArrayList<String>();
    	inter3.add("dragon");
    	Employee emp3 = new Employee("10004", "Danny", "Targalian", 24, true, inter3);
    	
        employeeService.save(emp1);
        employeeService.save(emp2);
        employeeService.save(emp3);

        //fuzzey search
        Page<Employee> emps = employeeService.findByFirstName("Tyrian", new PageRequest(0, 10));

        //List<Book> books = employeeService.findByTitle("Elasticsearch Basics");

        emps.forEach(x -> System.out.println(x));
    }

    //useful for debug, print elastic search details
    private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch--");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("--ElasticSearch--");
    }

}