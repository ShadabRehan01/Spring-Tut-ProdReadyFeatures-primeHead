package com.production.prod_ready_features;

import com.production.prod_ready_features.clients.EmployeeClients;
import com.production.prod_ready_features.dto.EmployeeDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdReadyFeaturesApplicationTests {
	//we are not going for creating controller, we used Testing for calling the third party API

	@Autowired
	private EmployeeClients employeeClients;

	@Test
	@Order(3)
	void getAllEmployees() {
		List<EmployeeDto> employeeDtoList=employeeClients.getAllEmployees();
		System.out.println(employeeDtoList);
	}
	@Test
	@Order(2)
	void getEmployeeById(){
		EmployeeDto employeeDto=employeeClients.getEmployeeById(1L);
		System.out.println(employeeDto);
	}
	@Test
	@Order(1)
	void createNewEmployee(){
		EmployeeDto employeeDto=new EmployeeDto(null,"Inam","Inam@123",20,"USER",50000.0,
				"05/05/2025",true);
		EmployeeDto savedEmployeeDto=employeeClients.createNewEmployee(employeeDto);
		System.out.println(savedEmployeeDto);
	}
}
