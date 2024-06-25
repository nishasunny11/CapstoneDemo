package com.gl.ems.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.ems.dto.DepartmentDTO;
import com.gl.ems.entity.Department;
import com.gl.ems.exception.ResourceNotFoundException;
import com.gl.ems.mapper.DepartmentMapper;
import com.gl.ems.repository.DepartmentRepository;
import com.gl.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
		Department department = DepartmentMapper.mapToDepartment(departmentDTO);
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDTO(savedDepartment);
	}

	@Override
	public DepartmentDTO getDepartmentById(int departmentId) {
		Department department = departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department with id "+departmentId+" does not exist"));
		return DepartmentMapper.mapToDepartmentDTO(department);
	}

	@Override
	public DepartmentDTO updateDepartmentById(int departmentId, DepartmentDTO departmentDTO) {
		Department department = departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department with id "+departmentId+" does not exist"));
		department.setDepartmentName(departmentDTO.getDepartmentName());
		department.setDepartmentDescription(departmentDTO.getDepartmentDescription());
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDTO(savedDepartment);
	}

	@Override
	public void deleteDepartmentById(int departmentId) {
		Department department = departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department with id "+departmentId+" does not exist"));
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public List<DepartmentDTO> getAllDepartments() {
		List<Department> departments=departmentRepository.findAll();
		return departments.stream().map((department)->DepartmentMapper.mapToDepartmentDTO(department)).collect(Collectors.toList());
	}


}