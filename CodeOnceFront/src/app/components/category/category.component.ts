import { Component, OnInit } from '@angular/core';
import {Input } from "@angular/core";
import {Product} from 'src/app/models/product.model';
import {Category} from 'src/app/models/category.model';
import { from, Observable } from 'rxjs';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  @Input() category : any ;

  constructor(private apiService : ApiService) { }

  deletecategory(data : any){
    this.apiService.deletecategory(data).subscribe();
    window.location.reload();
  }

  ngOnInit(): void {}

}
