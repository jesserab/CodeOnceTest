import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import{CatalogComponent} from 'src/app/components/catalog/catalog.component'
import{AddcategoryComponent} from 'src/app/components/addcategory/addcategory.component'
import { ProductsComponent } from './components/products/products.component';
const routes: Routes = [{path:'catalog', component : CatalogComponent},{path:'dashboard' , component : AddcategoryComponent},{path:'dispoproducts', component : ProductsComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
