import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import {ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app.routing';
import { NavbarModule } from './shared/navbar/navbar.module';
import { FooterModule } from './shared/footer/footer.module';
import { SidebarModule } from './sidebar/sidebar.module';

import { AppComponent } from './app.component';
import {AngularFireModule} from '@angular/fire';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { FirstComponent } from './first/first.component';

import { HttpModule } from '@angular/http';
import { environment } from 'environments/environment';

@NgModule({
  imports: [
    BrowserAnimationsModule,
   
    RouterModule,
    HttpClientModule,
    NavbarModule,
    FooterModule,
    SidebarModule,
    HttpModule,
    AppRoutingModule,
    ReactiveFormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    
    
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    FirstComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
