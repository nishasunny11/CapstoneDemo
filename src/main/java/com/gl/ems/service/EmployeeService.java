package com.gl.ems.service;

import java.util.List;

import com.gl.ems.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeById(int employeeId);

	EmployeeDTO updateEmployeeById(int employeeId, EmployeeDTO employeedto);

	void deleteEmployeeById(int employeeId);

	List<EmployeeDTO> getAllEmployees();
}
