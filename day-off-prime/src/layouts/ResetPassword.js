import React from 'react'
import "primereact/resources/themes/saga-blue/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';


export default function ResetPassword() {
  return (
    <div>
      <header>
        <InputText id="txtUserName" label="username"/>
        <br />
        <InputText id="txtMailAddress" />
        <br />
        <Button type="button" label="Check" icon="pi pi-check" ></Button>
      </header>

    </div>
  )
}
