import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { parse } from 'url';
import { Router } from '@angular/router';
import {Activity} from'../activity.model';
@Component({
  selector: 'app-typography',
  templateUrl: './typography.component.html',
  styleUrls: ['./typography.component.css']
})
export class TypographyComponent implements OnInit {
li1:any;
calories:any;
err:any;
list:any;
info:Activity[];
time:any;
day:any;
  constructor(private http:Http,private router:Router) { }

  ngOnInit() {
    this.http.get("http://ibmfsd07.iiht.tech:8011/profile/users/"+JSON.parse(localStorage.getItem("email"))).subscribe(data=>{
      this.li1=data.json();
      
this.list=(this.li1[0].plan).split(",");
this.calories=(this.li1[0].calories);

    })
  }

  save(minutes:string)
  {
 var value=(document.getElementById("select")  as HTMLInputElement).value;
 console.log(value);
 if(minutes=="")
 {
  this.err="This is required field";


 }
 
 
 else{
    
  switch(value)
  {
    case "Swimming":this.calories=parseInt(minutes)*240/30;

    case "Running":this.calories=parseInt(minutes)*270/30;

    case "Cycling":this.calories=parseInt(minutes)*120/20;

    case "DeadLifts":this.calories=parseInt(minutes)*100/10;

    case "BenchPress":this.calories=parseInt(minutes)*200/10;

    case "Pushups":this.calories=parseInt(minutes)*250/10;

    case "Swimmingfast":this.calories=parseInt(minutes)*360/30;

    case "Aerobicworkouts":this.calories=parseInt(minutes)*300/20;

    case "Runningfast":this.calories=parseInt(minutes)*360/30;

    case "Cyclingfast":this.calories=parseInt(minutes)*120/20;

    case "Walking":this.calories=parseInt(minutes)*120/30;

    case "Skipping":this.calories=parseInt(minutes)*500/20;

    case "Jogging":this.calories=parseInt(minutes)*300/30;

    case "Lunges&squats":this.calories=parseInt(minutes)*300/20;

    case "Yoga":this.calories=parseInt(minutes)*200/20;
  }
alert(this.calories);
var d=new Date();
var n=d.getDay();
switch(n)
{
  case 0:this.day="Sunday";break;
  case 1:this.day="Monday";break;
  case 2:this.day="Tuesday";break;
  case 3:this.day="Wednesday";break;
  case 4:this.day="Thursday";break;
  case 5:this.day="Friday";break;
  case 6:this.day="Saturday";break;
}
   const info={emailAddress:JSON.parse(localStorage.getItem("email")),activity:value,no_of_minutes:minutes,calories:this.calories,day:this.day}
  this.http.post("http://ibmfsd07.iiht.tech:8011/mails/",info).subscribe(data=>{
    
    this.router.navigate(['table']);
  });
  this.router.navigate(['table']);
 }
  }
 

}
