import { Component, OnInit } from '@angular/core';
import {Input } from "@angular/core";
import {Product} from 'src/app/models/product.model';
import { ApiService } from 'src/app/services/api.service';
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() product : any;
  constructor(private apiService : ApiService) { }

  deleteproduct(data : any){
    this.apiService.deleteproduct(data).subscribe();
    window.location.reload();
  }

  ngOnInit(): void {
  }

}
