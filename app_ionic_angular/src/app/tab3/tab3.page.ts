import { Component } from '@angular/core';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {

  arrayClients: any;

  constructor() {}

  ngOnInit(): void {
  
  }

  async getClients() {
    try {


      const token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTcwNDU1MjA5M30.PWIn549iMy9FMf8WrQeJcLD6zLvRlQdecTd5C0WKwle2iKPQooKiWe97pstwu2OXlvAU6ASwqK4z3mc1BgIxiQ';

      const requestOptions = {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${token}`,
        },
      };

      const response = await fetch('http://localhost:8080/api/clients', requestOptions);

      if (!response.ok) {
        throw Error(response.statusText);
      }

      const json = await response.json();
      this.arrayClients = json;

      console.log('Clients:', this.arrayClients);
    } catch (error) {
      console.error('Error fetching clients:', error);
    }
  }
}
