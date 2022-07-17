import { Account } from './../model/account';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AccountService {
  accountLoggedIn: Subject<Account> = new BehaviorSubject<Account>(undefined);
  constructor() {}
}
