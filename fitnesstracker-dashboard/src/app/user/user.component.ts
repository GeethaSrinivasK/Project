import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

import {ActivityService} from '../activity.service';
import {Activity} from '../activity.model';
import { isNull } from 'util';
import { isGeneratedFile } from '@angular/compiler/src/aot/util';
import { forEach } from '@angular/router/src/utils/collection';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {


 
  constructor(private http:Http,private service:ActivityService,private router:Router)
  {

  }
  username:any;
  email:any;
  list:Activity[];
  info:any;
  age:any;
  ht:any;
  wt:any;
  ph:any;
  act:any;
  li1:any;
  goal:number;
  info1="";
 
  ngOnInit() {

 this.username=JSON.parse(localStorage.getItem('username'));
 this.email=JSON.parse(localStorage.getItem('email'));
 /*this.http.get("http://ibmfsd07.iiht.tech:8011/profile/users/"+JSON.parse(localStorage.getItem("email"))).subscribe(data=>{
  this.li1=data.json();
 });
 */

  }
 
show()
{
 document.getElementById("tab").style.display="block";
     this.info="Gainweight";
     this.service.getlist(this.info).subscribe(data=>{
 this.list=data.json();
 
     });


}
     
     show1()
     {
      document.getElementById("tab").style.display="block";
      this.info="Lossweight";
      this.service.getlist(this.info).subscribe(data=>{
        this.list=data.json();
            });
     }         
 
validate(age1:string,height:string,weight:string,phonenumber:string)
{
  
 // var a=(document.getElementById("age") as HTMLInputElement).value;
  if(age1==""||height==""||weight==""||phonenumber=="")
  {

  
 if(age1=="")
 this.age="This is required field";
 else
 {
   if(parseInt((document.getElementById("age") as HTMLInputElement).value))
  this.age="";
  else
  this.age="Please enter valid age";
 }
 
 if(height=="")
 this.ht="This is required field";
 else if(parseInt((document.getElementById("height") as HTMLInputElement).value))
 {
  
  this.ht="";
 }
else
this.ht="please enter height in inches";
 

 if(weight=="")
 this.wt="This is required field";
 else if(parseInt((document.getElementById("weight") as HTMLInputElement).value))
 {
  
  this.wt="";
 }
  else
  this.wt="Please enter valid weight";
 
 
 if(phonenumber=="")
 this.ph="This is required field";
 else if(parseInt(phonenumber))
 {
  this.ph="";
 }
 else
 this.ph="please enter valid phone no";
}
else{
  var inputList = document.getElementsByName("xyz");
  var length=inputList.length;
  var numChecked = 0;
  for (var i = 0; i < length; i++) {
    if ((inputList[i] as HTMLInputElement).checked) {
      numChecked = numChecked + 1;
  }
 
}
if(numChecked!=3)
{
  this.act="Please select any 3 activities";
  var j=0;
 

 
}

else{
   
  var cell = document.getElementsByTagName("tr");
 
  
  for (var i = 0; i < length; i++) {
    if ((inputList[i] as HTMLInputElement).checked) {
    
      console.log(cell[i]);
  }
 
}
  localStorage.setItem("activity",JSON.stringify(this.list));
  var j=0;
  this.goal=0;
  for(var k=0;k<length;k++){
  if ((inputList[k] as HTMLInputElement).checked) {
    console.log(this.list[k].plan+""+this.info);
    this.info1=this.info1+","+this.list[k].plan;
    this.goal=this.goal+this.list[k].calories;
    console.log(this.list[k].calories);
    j++;
  }
 
}
 const details={email:this.email,
                 username:this.username,
                 activity:this.info,plan:this.info1,
                 height:height,weight:weight,mobileno:phonenumber,age:age1,calories:this.goal} ;
                 
               
                 this.http.post("http://ibmfsd07.iiht.tech:8011/profile/users",details).subscribe(data=>{
                   
                   alert("Data saved successfully");
                   this.router.navigate(['typography']);
                 })
                               
  this.act="";
}
console.log(numChecked);
}

  
 
}
hide()
{
  this.age="";
}
hide1()
{this.ht="";

}
hide2()
{
  this.wt="";
}
hide3()
{
  this.ph="";
}
}
