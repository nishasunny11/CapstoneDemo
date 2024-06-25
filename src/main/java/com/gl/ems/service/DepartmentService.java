package com.gl.ems.service;

import java.util.List;

import com.gl.ems.dto.DepartmentDTO;

public interface DepartmentService {

	DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

	DepartmentDTO getDepartmentById(int departmentId);

	DepartmentDTO updateDepartmentById(int departmentId,DepartmentDTO departmentDTO);

	void deleteDepartmentById(int departmentId);

	List<DepartmentDTO> getAllDepartments();

}
