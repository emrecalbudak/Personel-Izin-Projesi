import React, {useEffect, useState} from 'react'
import { InputText } from 'primereact/inputtext'
import "primereact/resources/themes/saga-green/theme.css";
import "primereact/resources/themes/arya-blue/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import { Button } from "primereact/button";
import EmployeeService from './services/employeeService';
import axios from './api/axios';


export default function AddDayOff() {
   const [employeeId, setEmployeeId] = useState("");
   const [startDate, setStartDate] = useState("");
   const [endDate, setEndDate] = useState("");
   const [remaining, setRemaining] = useState("");

   
   const handleEmployeeId = (e) => {
      setEmployeeId(e.target.value);
   }
   const handleStartDate = (e) => {
      setStartDate(e.target.value);
   }
   const handleEndDate = (e) => {
      setEndDate(e.target.value);
   }
   const handleRemaining = (e) => {
      setRemaining(e.target.value);
   }

    const obj ={
      employeeId:employeeId,
      startDate:startDate,
      endDate:endDate,
      remaining:remaining
   }

   const add = (e) => {
      e.preventDefault();
      axios.post("http://localhost:8080/api/dayoff/add",{...obj});
      console.log(obj); 
   }

  return (
    <div className='App-header'>
      <form onSubmit={add}>
         <InputText id='id' placeholder='ID' type={"text"} onChange={handleEmployeeId}></InputText>
         <br/>
         <InputText id='startDate' placeholder='Start Date' type={"date"} onChange={handleStartDate}></InputText>
         <br/>
         <InputText id='endDate' placeholder='End Date' type={"date"} onChange={handleEndDate}></InputText>
         <br/>
         <InputText id='remaining' placeholder='remaining' type={"text"} onChange={handleRemaining}></InputText>
         <br/>
         <Button id="addDayOff" label="Add"></Button>
      </form>
    </div>
  )
}
