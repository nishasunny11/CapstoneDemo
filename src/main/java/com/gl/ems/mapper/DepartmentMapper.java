package com.gl.ems.mapper;

import com.gl.ems.dto.DepartmentDTO;
import com.gl.ems.entity.Department;

public class DepartmentMapper {
	
	public static DepartmentDTO mapToDepartmentDTO(Department department) {
		return new DepartmentDTO(department.getId(), department.getDepartmentDescription(),department.getDepartmentName());
	}
	
	
	public static Department mapToDepartment(DepartmentDTO departmentDto) {
		return new Department(departmentDto.getId(),departmentDto.getDepartmentDescription(),departmentDto.getDepartmentName());
	}
	
}
