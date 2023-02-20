import React, { useState, useEffect } from "react";
//import { Route } from "react-router";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Button} from 'primereact/button';
import DayOffService from "./services/dayOffService";



export default function DayOffPage() {
  const [dayOffDatas, setDayOffDatas] = useState();


   useEffect(() => {
    let dayOffService = new DayOffService();
    dayOffService.getDayOff()
      .then((result) => setDayOffDatas(result.data.data));
  }, []);

  return (
    <div>
      <div>
      <div className="card p-fluid">
        <h5>Day Off List List</h5>
        <DataTable
          dataKey="id"
          value={dayOffDatas}
          emptyMessage="No data found"
          editMode="cell"
          className="editable-cells-table"
          filterDisplay="row"
          responsiveLayout="scroll"
          
        >
          <Column field="employee.identityNo" header="Identity No"  sortable filter></Column>
          <Column field="employee.firstName" header="First Name" sortable filter></Column>
          <Column field="employee.lastName" header="Last Name" sortable filter></Column>
          <Column field="startDate" header="Start Date" sortable filter></Column>
          <Column field="endDate" header="End Date" sortable filter></Column>
          <Column field="remaining" header="Remaining" sortable filter></Column>
          
        </DataTable>
      </div>
    </div>
    <Button label="All"></Button>
    <Button label="Now"></Button>
    <Button label="Add"></Button>
    <Button label="Remove"></Button>
    </div>
  );
}
