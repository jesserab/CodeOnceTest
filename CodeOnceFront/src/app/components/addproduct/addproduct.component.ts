import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  public categories : any;
  constructor(private apiService : ApiService) { }

  click(id : any, data:any){
      this.apiService.addproduct(id,data).subscribe();
      window.location.reload();
  }

  ngOnInit(): void {
      this.apiService.getcategories()
          .subscribe(data => this.categories=data);
  }

}
