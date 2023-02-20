package orion.Dayoff.api.controller;

//import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orion.Dayoff.Core.utilities.results.Result;
import orion.Dayoff.dto.EmployeeDto;
import orion.Dayoff.entity.Employee;
import orion.Dayoff.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployeeDto employee) {
		return this.employeeService.add(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deleteById(@PathVariable Integer id){
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
}
