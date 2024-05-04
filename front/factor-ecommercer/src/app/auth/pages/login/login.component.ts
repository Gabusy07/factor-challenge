import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
navigateToRegiste() {
throw new Error('Method not implemented.');
}

public form:FormGroup;

constructor(private readonly formBuilder : FormBuilder,
   private readonly route: Router
  ) {

  this.form = this.initForm();
  
 }

  private initForm(): FormGroup{
    return this.formBuilder.group({
      email: ['',[Validators.required, Validators.email]],
      password: ['',[Validators.required, Validators.minLength(5), Validators.maxLength(18)]],
    })

  }

  get Email(){
    return this.form.get('email');
  }

  get Password(){
    return this.form.get('password');
  }

  send() {
    this.route.navigate(['']);
    }
}
