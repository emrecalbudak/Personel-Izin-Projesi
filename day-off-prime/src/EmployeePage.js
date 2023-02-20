import React, { useState, useEffect } from "react";
import { DataTable } from "primereact/datatable";
import "primereact/resources/themes/saga-green/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import "primereact/resources/themes/arya-blue/theme.css";
import { Column } from "primereact/column";
import EmployeeService from "./services/employeeService";
import { Button } from "primereact/button";



export default function EmployeePage() {

  const [Employees, setEmployees] = useState();
  
  //EmployeeService = new EmployeeService();

  useEffect(() => {
    let employeeService = new EmployeeService();
    employeeService.getEmployee().then((result) => setEmployees(result.data.data));
    console.log(Employees);
  },[Employees]);


  return (

    <div>
     {/* <Router>
        <switch>
          <Route exact path="./AddEmployee.js" component={AddEmployee}/>
          <Route exact path="./DayOffPage.js" component={DayOffPage}/>
        </switch>
      </Router>  */}
      <form >
        <div className="card p-fluid">
        <h5>Employee List</h5>
        <DataTable 
          dataKey="id"
          value={Employees}
          editMode="cell"
          className="editable-cells-table"
          filterDisplay="row"
          emptyMessage="No data found"
          responsiveLayout="scroll"
        >
            <Column field="id" sortable header="ID"></Column>
            <Column field="identityNo" sortable filter header="Identity No" ></Column>
            <Column field="firstName" sortable filter header="First Name" ></Column>
            <Column field="lastName" sortable filter header="Last Name" ></Column>
            <Column field="address" sortable filter header="Address" ></Column>
            <Column field="mailAddress" sortable filter header="Mail Address" ></Column>
            <Column field="startDate" sortable filter header="Start Date" ></Column>
        </DataTable>
        </div>  
      </form>

      
      <br />
      <Button label="Add Employee" onClick={""}> </Button>
      <Button icon="pi pi-arrow-circle-up" label="Show Day Off Page"></Button>
    </div>
  );
}