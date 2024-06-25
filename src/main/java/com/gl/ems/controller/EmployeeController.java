package com.gl.ems.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gl.ems.dto.EmployeeDTO;
import com.gl.ems.serviceImpl.EmployeeServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl empImpl;
    
	@PostMapping
	ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO empDto ){
		EmployeeDTO empDto1=empImpl.createEmployee(empDto);
		return new ResponseEntity<EmployeeDTO>(empDto1,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") int empId){
		EmployeeDTO empDto=empImpl.getEmployeeById(empId);
		return new ResponseEntity<EmployeeDTO>(empDto,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") int empId,@RequestBody EmployeeDTO empDTO){
		EmployeeDTO empDto=empImpl.updateEmployeeById(empId, empDTO);
		return new ResponseEntity<EmployeeDTO>(empDto,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("{id}")
	ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable("id") int empId){
		empImpl.deleteEmployeeById(empId);
		return new ResponseEntity("Employee with id"+empId+" deleted Successfully",HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping
	ResponseEntity<EmployeeDTO> getAllEmployee(){
		List<EmployeeDTO> listEmp=empImpl.getAllEmployees();
		return new ResponseEntity(listEmp,HttpStatus.OK);
	}

}