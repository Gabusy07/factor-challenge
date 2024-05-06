import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  navigateToRegiste() {
    throw new Error('Method not implemented.');
  }

  public form: FormGroup;

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly route: Router,
    private readonly loginService: LoginService,
  ) {
    this.form = this.initForm();
  }

  private initForm(): FormGroup {
    return this.formBuilder.group({
      username: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(18)]],
    });
  }

  get Username() {
    return this.form.get('username');
  }

  get Password() {
    return this.form.get('password');
  }

  send() {
    this.loginService.login(this.form.value).subscribe({
      next: (data) => {
        alert('Inicio de sesión exitoso');
        this.route.navigate(['']);
      },
      error: (error) => {
        if (error.error === 'username incorrect') this.Username?.setErrors({incorrect: true});
        else if (error.error === 'password incorrect') this.Password?.setErrors({incorrect: true});
        console.error('Error al iniciar sesión ', error.error);
      },
    });
  }
}
