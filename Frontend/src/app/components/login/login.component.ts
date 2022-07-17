import { User } from './../../model/user';
import { AccountService } from './../../services/account.service';
import { Router } from '@angular/router';
import { Account } from './../../model/account';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;
  invalidLogin: boolean;
  hide = true;
  constructor(
    private authService: AuthService,
    private router: Router,
    private accountService: AccountService
  ) {}

  ngOnInit(): void {}

  handleLogin() {
    this.authService
      .login(this.username, this.password)
      .subscribe((response: HttpResponse<User>) => {
        console.log(response);
        localStorage.setItem('user', JSON.stringify(response.body['user']));
        localStorage.setItem('theToken', response.body['token']);
        console.log('Logged In successfully');
      });
  }
}
