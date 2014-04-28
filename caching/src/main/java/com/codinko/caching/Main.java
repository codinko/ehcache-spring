package com.codinko.caching;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		List<Employee> employees;
		Employee employee;
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		EmployeeDAO dao = (EmployeeDAO)context.getBean("employeeDAO");
		employees = dao.getEmployees();
		System.out.println(employees.toString());
		System.out.println("---------------------------------------------------");
		employees = dao.getEmployees();
		System.out.println(employees.toString());
		System.out.println("---------------------------------------------------");
		employees = dao.getEmployees();
		System.out.println(employees.toString());
		System.out.println("---------------------------------------------------");
		employee = dao.getEmployee("Harley", employees);
		System.out.println(employee.toString());
		employee = dao.getEmployee("Harley", employees);
		System.out.println(employee.toString());
		
	}
}
