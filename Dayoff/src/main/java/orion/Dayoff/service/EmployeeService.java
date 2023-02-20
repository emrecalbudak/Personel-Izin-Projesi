package orion.Dayoff.service;

import java.util.List;

import orion.Dayoff.Core.utilities.results.Result;
import orion.Dayoff.dto.EmployeeDto;
import orion.Dayoff.entity.Employee;

public interface EmployeeService {
	//DataResult<List<EmployeeDto>> getAll();
	Result add(EmployeeDto employee);
	List<Employee> getAll();
}
