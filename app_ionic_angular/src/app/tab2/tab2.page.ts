import { Component } from '@angular/core';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {

  firstName: any;
  lastName: any;
  email: any;
  langKey: any;
  authorities: any;


  constructor() {}

  ngOnInit(): void {
  
  }

  async getUserData() {
    try {
      const token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTcwNDU1MjA5M30.PWIn549iMy9FMf8WrQeJcLD6zLvRlQdecTd5C0WKwle2iKPQooKiWe97pstwu2OXlvAU6ASwqK4z3mc1BgIxiQ';

      const requestOptions = {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${token}`,
        },
      };

      const response = await fetch('http://localhost:8080/api/account', requestOptions);

      if (!response.ok) {
        throw Error(response.statusText);
      }

      const json = await response.json();
      this.firstName = json.firstName;
      this.lastName = json.lastName;
      this.email = json.email;
      this.langKey = json.langKey;
      this.authorities = json.authorities

      console.log('User data:', json);
    } catch (error) {
      console.error('Error fetching user data:', error);
    }
  }
}


