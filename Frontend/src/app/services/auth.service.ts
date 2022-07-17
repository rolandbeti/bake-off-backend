import { Observable } from 'rxjs';
import { User } from './../model/user';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  rootUrl: string = 'http://localhost:8081';
  token: string;

  constructor(private htpClient: HttpClient) {}

  login(username: string, password: string): Observable<HttpResponse<User>> {
    return this.htpClient.post<User>(
      `${this.rootUrl}/api/login`,
      {
        username: username,
        password: password,
      },
      {
        observe: 'response',
      }
    );
  }
}
