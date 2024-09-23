package com.cls.mapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MappingApplication {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(MappingApplication.class, args);
//		EmployeeRepository empRepo = con.getBean(EmployeeRepository.class);
//
//		Employee employee = new Employee();
//		employee.setEmpId(43);
//		employee.setEmpName("Dhiraj");
//
//		Laptop laptop = new Laptop();
//		laptop.setLapID(123);
//		laptop.setModel("Asus ROG");
//		laptop.setPrice(102000);
//
//		employee.setLaptop(laptop);  // Set the laptop to the employee
//
//		empRepo.save(employee);  // Save the employee (which will also save the laptop due to CascadeType.ALL)
		StudentRepository repo = (StudentRepository) con.getBean("studentRepository");

		Student student = new Student();
		student.setId(43);
		student.setName("Dhiraj Gupta");

		Address address1 = new Address();
		address1.setAdd_id(1);
		address1.setCity("Butwal");
		address1.setState("Lumbini");
		address1.setStudent(student); // Set student

		Address address2 = new Address();
		address2.setAdd_id(2);
		address2.setCity("Jatni");
		address2.setState("Odisha");
		address2.setStudent(student); // Set student

		List<Address> addresses = new ArrayList<>();
		addresses.add(address1);
		addresses.add(address2);

		student.setAddressList(addresses);
		repo.save(student);
	}
}
