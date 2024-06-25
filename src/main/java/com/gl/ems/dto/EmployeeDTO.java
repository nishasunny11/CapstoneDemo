package com.gl.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

	private int employeId;
	private String firstName;
	private String lastName;
	private String email;
	private int departmentId;
}

