import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit {

  arrayAuthors: any;

  constructor() {}

  ngOnInit(): void {
  
  }

  async getAuthors() {
    try {
      const token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTcwNDU1MjA5M30.PWIn549iMy9FMf8WrQeJcLD6zLvRlQdecTd5C0WKwle2iKPQooKiWe97pstwu2OXlvAU6ASwqK4z3mc1BgIxiQ';

      const requestOptions = {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `Bearer ${token}`,
        },
      };

      const response = await fetch('http://localhost:8080/api/authors', requestOptions);

      if (!response.ok) {
        throw Error(response.statusText);
      }

      const json = await response.json();
      this.arrayAuthors = json;

      console.log('Authors:', this.arrayAuthors);
    } catch (error) {
      console.error('Error fetching authors:', error);
    }
  }
}

