import axios from 'axios';

export default class LoginService{
   getAdmin(){
      return axios.getAdmin("http://localhost:8080/login")
   }
}