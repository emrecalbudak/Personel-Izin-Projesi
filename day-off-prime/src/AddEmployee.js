import React, { useState} from "react";
import { InputText } from "primereact/inputtext";
import "primereact/resources/themes/saga-green/theme.css";
import "primereact/resources/themes/arya-blue/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import { Button } from "primereact/button";
import axios from "./api/axios";

export default function AddEmployee() {


  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [identityNo, setIdentityNo] = useState("");
  const [startDate, setStartDate] = useState("");
  const [mailAddress, setMailAddress] = useState("");
  const [address, setAddress] = useState("");

  const handleFirstName = (e) => {
    setFirstName(e.target.value);
  };

  const handleLastName = (e) =>{
    setLastName(e.target.value);
  }

  const handleIdentityNo = (e) =>{
   setIdentityNo(e.target.value);
 }
 const handleStartDate = (e) =>{
   setStartDate(e.target.value);
 }
 const handleMailAddress = (e) =>{
   setMailAddress(e.target.value);
 }
 const handleAddress = (e) =>{
   setAddress(e.target.value);
 }
 const obj = {
   firstName:firstName,
   lastName:lastName,
   identityNo:identityNo,
   startDate:startDate,
   mailAddress:mailAddress,
   address:address
 }

  const add = (e) => {
   e.preventDefault();
   axios.post("http://localhost:8080/api/employee/add",{...obj}); //çalışıyor... :)))

   console.log(obj);
  }

  return (
    <div className="App-header" >
      <form onSubmit={add}>
        <InputText id="firstName" placeholder="First Name" type={"text"} onChange={handleFirstName} ></InputText>
        <br />
        <InputText id="lastName" placeholder="Last Name" type={"text"} onChange={handleLastName}></InputText>
        <br />
        <InputText id="identityNo" placeholder="Identity Number" type={"text"} onChange={handleIdentityNo}></InputText>
        <br />
        <InputText id="startDate" placeholder="Start Date (YYYY-MM-GG)" type={"date"} onChange={handleStartDate}></InputText>
        <br />
        <InputText id="mailAddress" placeholder="mail address" type={"email"} onChange={handleMailAddress}></InputText>
        <br />
        <InputText id="address" placeholder="Address" type={"text"} onChange={handleAddress}></InputText>
        <br />
        <Button id="addEmployee" label="Add" onClick={""}></Button>
      </form>
    </div>
  );
}
