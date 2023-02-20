package orion.Dayoff.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import orion.Dayoff.Core.utilities.results.Result;
import orion.Dayoff.dto.EmployeeDto;
import orion.Dayoff.entity.Employee;
import orion.Dayoff.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	@Autowired
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository){
		super() ;
		this.employeeRepository=employeeRepository;
	}
	@Override
	public Result add(EmployeeDto employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	

}
