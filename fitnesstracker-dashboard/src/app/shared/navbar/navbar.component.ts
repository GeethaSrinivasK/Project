import { Component, OnInit, ElementRef } from '@angular/core';
import { ROUTES } from '../../sidebar/sidebar.component';
import {Location, LocationStrategy, PathLocationStrategy} from '@angular/common';
import {Router} from'@angular/router';
@Component({
    // moduleId: module.id,
    selector: 'navbar-cmp',
    templateUrl: 'navbar.component.html'
})

export class NavbarComponent implements OnInit{
    ngOnInit()
    {
    }
    constructor(private router:Router){}
    signOut() {
        localStorage.removeItem("LoggedInUser");
      this.router.navigate(['']);
      }
   
}
