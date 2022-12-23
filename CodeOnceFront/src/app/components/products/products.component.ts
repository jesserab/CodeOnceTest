import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  public products : any;

  constructor(private apiService : ApiService) { }

  getproducts(data : any){
    this.apiService.getdispoproducts(data)
          .subscribe(data => this.products=data);
  }

  ngOnInit(): void {
  }

}
