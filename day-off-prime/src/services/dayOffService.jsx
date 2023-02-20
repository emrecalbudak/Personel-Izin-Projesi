import axios from "../api/axios";

export default class DayOffService{
   getDayOff(){
      return axios.get("http://localhost:8080/api/dayoff/getall");
   }
}