import { Component, OnInit } from '@angular/core';
import {Product} from 'src/app/models/product.model';
import {Category} from 'src/app/models/category.model';
import { ApiService } from 'src/app/services/api.service';
import { from, Observable } from 'rxjs';
@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent {

  public categories : any ;

  constructor(private apiService : ApiService) { }

  ngOnInit(){
      this.apiService.getcategories()
         .subscribe(data => this.categories=data);
  }
}
