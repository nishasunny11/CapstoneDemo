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
import com.gl.ems.dto.DepartmentDTO;
import com.gl.ems.serviceImpl.DepartmentServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
    @Autowired
	DepartmentServiceImpl deptImpl;
    
    @PostMapping
   ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO deptDto){
    	 
	   DepartmentDTO deptDto1= deptImpl.createDepartment(deptDto);
	   System.out.println("Looks Fine");
	   return new ResponseEntity<DepartmentDTO>(deptDto1,HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
    ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") int departmentId){
    	
    	DepartmentDTO dept=deptImpl.getDepartmentById(departmentId);
    			return new ResponseEntity<DepartmentDTO>(dept,HttpStatus.OK);
    	
    }
    
    @PutMapping("{id}")
    ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") int departmentId,@RequestBody DepartmentDTO deptDto){
    	DepartmentDTO dept=deptImpl.updateDepartmentById(departmentId, deptDto);
    	return new ResponseEntity<DepartmentDTO>(dept,HttpStatus.OK);
    }
    @SuppressWarnings("unchecked")
	@DeleteMapping("{id}")
    ResponseEntity<DepartmentDTO> deleteDepartment(@PathVariable("id") int departmentId){
    	deptImpl.deleteDepartmentById(departmentId);
    	return new ResponseEntity("Department deleted Successfully",HttpStatus.OK);
    }
    @SuppressWarnings("unchecked")
	@GetMapping
    ResponseEntity<DepartmentDTO> getAllDepartment(){
    	List<DepartmentDTO> dept=deptImpl.getAllDepartments();
    	return new ResponseEntity(dept,HttpStatus.OK);
    }
}