package com.gl.ems.mapper;

import com.gl.ems.dto.EmployeeDTO;
import com.gl.ems.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
		return new EmployeeDTO(employee.getEmployeId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartment().getId());
	}
	
	
	public static Employee mapToEmployee(EmployeeDTO employeeDto) {
		Employee employee = new Employee();
		employee.setEmployeId(employeeDto.getEmployeId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		return employee;
	}
}
