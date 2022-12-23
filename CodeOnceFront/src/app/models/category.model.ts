import {Product} from './product.model'
export class Category {
    id : number ;
    name : string ;
    description : string ;
    products: Array<Product> = [];

    constructor(){}
}
