package orion.Dayoff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import orion.Dayoff.Core.utilities.results.Result;
import orion.Dayoff.dto.EmployeeDto;
import orion.Dayoff.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee getByFirstName(String firstName);
	void deleteById(Integer id);
	List<Employee> findAll();
	List<Employee> getByFirstNameStartsWith(String firstName);
	@Query("From Employee where first_name=:firstName and id=:id")
	List<Employee> getByFirstNameAndId(String firstName, int id);
	List<Employee> getByFirstNameContains(String firstName);
	Employee getIdByIdentityNo(String identityNo);
	Result save(EmployeeDto employee);


}
