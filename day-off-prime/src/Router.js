import React, { Component } from 'react'
import {Router, Switch, Route} from "react-router-dom";
import EmployeePage from './EmployeePage';
import AddEmployee from './AddEmployee';
import AddDayOff from './AddDayOff';
import DayOffPage from './DayOffPage';
import history from './history';


export default class Routes extends Component{
  render(){
      return (
         <Router history={history}>
            <Switch>
               <Route path='/' exact component={DayOffPage}/>
                  <Route path='/EmployeePage'exact component={EmployeePage}/>
                  <Route path='/DayOffPage' component={DayOffPage}/>
            </Switch>
         </Router>
      )
  } 
  
}
