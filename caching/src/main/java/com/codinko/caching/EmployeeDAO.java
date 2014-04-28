package com.codinko.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component("employeeDAO")
public class EmployeeDAO {

	@Cacheable(value = "employeeCache")
	public List<Employee> getEmployees() {
		Random random = new Random();
		int randomid = random.nextInt(9999);
		System.out.println("*** Creating a list of employees and returning the list ***");
		List<Employee> employees = new ArrayList<Employee>(5);
		employees.add(new Employee(randomid, "Ben", "Architect"));
		employees.add(new Employee(randomid + 1, "Harley", "Programmer"));
		employees.add(new Employee(randomid + 2, "Peter", "BusinessAnalyst"));
		employees.add(new Employee(randomid + 3, "Sasi", "Manager"));
		employees.add(new Employee(randomid + 4, "Abhi", "Designer"));
		return employees;
	}

	@Cacheable(value = "employeeCache", key = "#name")
	public Employee getEmployee(String name, List<Employee> employees) {
		System.out
				.println("*** Get the employee using name : " + name + " ***");
		Employee emp = null;
		for (Employee employee : employees) {
			if (employee.getName().equalsIgnoreCase(name)) {
				emp = employee;
			}
		}
		return emp;
	}

}
