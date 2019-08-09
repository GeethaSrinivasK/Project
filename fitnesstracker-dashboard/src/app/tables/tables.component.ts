import { Component, OnInit } from '@angular/core';
import {HttpClient} from'@angular/common/http';
import {Data} from './Data';
import { Chart } from 'chart.js';
@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css']
})
export class TablesComponent implements OnInit {
  
  title = 'app';
  data: Data[];
  url = 'http://ibmfsd07.iiht.tech:8011/mails/'+JSON.parse(localStorage.getItem("email"));
  day= [];
  calories= [];
  chart :any;
  constructor(private httpClient: HttpClient) {}
  ngOnInit() {
    this.calories.push(0);
    this.day.push(" ");
    this.httpClient.get(this.url).subscribe((res: Data[]) => {
      res.forEach(y => {
        this.day.push(y.day);
        this.calories.push(y.calories);
      });
      this.chart = new Chart('canvas', {
        type: 'bar',
        
        data: {
          labels:this.day,
          
          datasets: [
            {
              data: this.calories,
              borderColor: '#3cba9f',
              backgroundColor:"blue",
              
              fill: false
            }
          ]
        },
        options: {
          legend: {
            display: false,
            
          },
          scales: {
            xAxes: [{
              display: true,
              barPercentage:0.4
              

            }],
            yAxes: [{
              display: true,
              
            }],
            
          }
        }
      });
    });
  }
}
