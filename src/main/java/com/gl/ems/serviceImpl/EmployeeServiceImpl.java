package com.gl.ems.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.ems.dto.EmployeeDTO;
import com.gl.ems.entity.Department;
import com.gl.ems.entity.Employee;
import com.gl.ems.exception.ResourceNotFoundException;
import com.gl.ems.mapper.EmployeeMapper;
import com.gl.ems.repository.DepartmentRepository;
import com.gl.ems.repository.EmployeeRepository;
import com.gl.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
     @Autowired
	EmployeeRepository empRepo;
     
     @Autowired
     DepartmentRepository deptRepo;
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO empDto) {
		Employee emp=EmployeeMapper.mapToEmployee(empDto);
		Department dept=deptRepo.findById(empDto.getDepartmentId()).orElseThrow(()->new ResourceNotFoundException("Department id doesn't exist"+empDto.getDepartmentId()));
		emp.setDepartment(dept);
		Employee emp1=empRepo.save(emp);
		return EmployeeMapper.mapToEmployeeDTO(emp1);
	}

	@Override
	public EmployeeDTO getEmployeeById(int empId) {
Employee emp=empRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Department With Id:"+empId+"Doesn't Exist"));
		
		// TODO Auto-generated method stub
		return  EmployeeMapper.mapToEmployeeDTO(emp);
	}

	@Override
	public EmployeeDTO updateEmployeeById(int empId,EmployeeDTO empDto) {
		Employee emp=empRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Department With Id:"+empId+"Doesn't Exist"));
		 emp.setFirstName(empDto.getFirstName());
		 emp.setLastName(empDto.getLastName());
		 emp.setEmail(empDto.getEmail());
		
		 Employee savedEmp=empRepo.save(emp);
			// TODO Auto-generated method stub
			return EmployeeMapper.mapToEmployeeDTO(savedEmp);
	}

	@Override
	public void deleteEmployeeById(int empId) {
		Employee emp=empRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Department With Id:"+empId+"Doesn't Exist"));
		empRepo.deleteById(empId);
		
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> listEmp=	empRepo.findAll();
		return listEmp.stream().map((employee)->EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
	}

}