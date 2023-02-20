import React from "react";
import "./App.css";
import EmployeePage from "./EmployeePage";
import DayOffPage from "./DayOffPage";
import AddEmployee from "./AddEmployee";
import AddDayOff from "./AddDayOff";
import Login from "./Login"
import { BrowserRouter, NavLink, Routes, Route } from "react-router-dom";



export default function App() {
  return (
    <BrowserRouter> 
    <header>
      <h1> App</h1>
    </header>
    <nav>
        <NavLink to={"Login"}>Login</NavLink><br/>
        <NavLink to={"EmployeePage"}>EmployeePage</NavLink><br/>
        <NavLink to={"addEmployee"}>AddEmployee</NavLink><br/>
        <NavLink to={"DayOffPage"}>DayOffPage</NavLink><br/>
        <NavLink to={"addDayOff"}>AddDayOff</NavLink>
    </nav>

    <Routes>
      <Route path="login" element={<Login/>}/>
      <Route path="employeepage" element={<EmployeePage/>}/>
      <Route path="addemployee" element={<AddEmployee/>}/>
      <Route path="dayoffpage" element={<DayOffPage/>}/>
      <Route path="adddayoff" element={<AddDayOff/>}/>
    </Routes>
    </BrowserRouter>
  )
}
