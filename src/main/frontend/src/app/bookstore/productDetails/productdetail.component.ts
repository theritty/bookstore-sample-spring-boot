import {Component, OnInit} from '@angular/core';
import {ProductsService} from "../services/ProductsService";
import {Product} from "../models/product.model";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'product-detail',
    templateUrl: './productdetail.component.html',
    styleUrls: ['./productdetail.component.css']
})
export class ProductDetailComponent implements OnInit {
    product;

    id: number = 1;
    quantity: number = 1;
    constructor(private productsService: ProductsService, private activatedRoute: ActivatedRoute) {

    }

    ngOnInit() {
        this.activatedRoute.params.subscribe(params => {
            this.id = params['id'];
            this.getProduct();
        });
    }

    getProduct() {
        this.productsService.getProduct(this.id)
            .subscribe(
                (product: Product) => {
                    this.product = product;
                    debugger;
                },
                (error) => console.log(error)
            );
    }


    createArray(n: number): any[] {
        debugger;
        return Array(n);
    }

}
