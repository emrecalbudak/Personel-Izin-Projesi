import axios from 'axios';

export default class EmployeeService{
   getEmployee(){
      return axios.get("http://localhost:8080/api/employee/getall");
   }
   addEmployee(){
      return axios.post("http://localhost:8080/api/employee/add");
   }
   getEmployeeId(){
      return axios.get("http://localhost:8080/api/employee/getIdByIdentityNo?");
   }

}
