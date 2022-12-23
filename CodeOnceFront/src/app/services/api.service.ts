import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders} from '@angular/common/http';
import {Category} from 'src/app/models/category.model';
import {Product} from 'src/app/models/product.model';
import { from, Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})

export class ApiService {
  constructor(private httpclient : HttpClient){ }

  private url : String ="http://localhost:8080"

  public getcategories() : Observable<Category[]> {
      return this.httpclient.get<Category[]>(this.url+'/categories');
  }

  public addcategory(data : any): Observable<Category> {
     return this.httpclient.post<Category>(this.url+'/category',data);
  }

  public deletecategory(data : any) {
    return this.httpclient.delete(this.url+'/category/'+data);
  }

  public addproduct(id:any,data:any) : Observable<Product> {
     return this.httpclient.post<Product>(this.url+'/product/'+id,data);
  }

  public getdispoproducts(data : any) : Observable<Product[]>{
    return this.httpclient.get<Product[]>(this.url+'/productdispoBycategname/'+data.name);
  }

  public deleteproduct(data : any) {
    return this.httpclient.delete(this.url+'/product/'+data)
  }

}