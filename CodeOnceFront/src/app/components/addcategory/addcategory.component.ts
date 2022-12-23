import { Component, OnInit } from '@angular/core';
import {Product} from 'src/app/models/product.model';
import {Category} from 'src/app/models/category.model';
import { ApiService } from 'src/app/services/api.service';
import { from, Observable } from 'rxjs';

@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.css']
})
export class AddcategoryComponent implements OnInit {

  category : Category = new Category();
  constructor(private apiService : ApiService) { }

  Ajout(data : any){
    this.apiService.addcategory(data).subscribe(
    )
    window.location.reload();
  }
  ngOnInit(): void {
  }

}
