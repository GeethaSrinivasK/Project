import { Component, OnInit } from '@angular/core';
import {RegisterService} from '../register.service';
import { Router} from '@angular/router';
import {AuthService} from'../auth.service';
declare const gapi: any;
@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.scss']
})
export class FirstComponent implements OnInit {

  constructor(private regservice:RegisterService,private router:Router,private auth: AuthService) { }

  ngOnInit() {
  }
  public auth2: any;
 public email:any;
 public  username:any;
  info:any;
   flag:any;
  
  
   public googleInit() {
     gapi.load('auth2', () => {
       this.auth2 = gapi.auth2.init({
         client_id: '44132427668-hu1qkd9t6o3fafrotn3gmjvk7eaod82e.apps.googleusercontent.com',
         cookiepolicy: 'single_host_origin',
         scope: 'profile email'
       });
       if(document.getElementById('googleBtn'))
       this.attachSignin(document.getElementById('googleBtn'));
       if(document.getElementById('gtn'))
       this.attachSign(document.getElementById('gtn'));
     });
   }
   public attachSignin(element) {
     this.auth2.attachClickHandler(element, {},
       (googleUser) => {
       
         let profile = googleUser.getBasicProfile();
         const user={email:profile.getEmail(),username:profile.getName()};
      //  this.username=profile.getName();
        //this.email=profile.getEmail();
    
        localStorage.setItem('username',JSON.stringify(user.username));
        localStorage.setItem('email',JSON.stringify(user.email));
           this.regservice.register(user).subscribe(data=>{
            this.auth.sendToken(JSON.stringify(user.username));
             this.router.navigate(['dashboard']);
           });
         });
   }
   public attachSign(element) {
     this.auth2.attachClickHandler(element, {},
       (googleUser) => {
     
       
         let profile = googleUser.getBasicProfile();
         const user={email:profile.getEmail(),username:profile.getName()};
         this.regservice.validate().subscribe(data=>{
           this.info=data.json();
           for(let i=0;i<this.info.length;++i)
           {
             if(this.info[i].email==user.email&& this.info[i].username==user.username)
                {
                        this.flag=1;
                
 
                }
           }
           if(this.flag==0)
           {
             alert("Account does not exist with this user ,Please Register");
              
        
           }
         
           else{
             this.router.navigate(['dashboard']);
           }
          });
        
       });
     }
 
 ngAfterViewInit(){
       this.googleInit();
 }
 scroll()
 {
   document.getElementById("scroll").style.display="block";
 }
}
