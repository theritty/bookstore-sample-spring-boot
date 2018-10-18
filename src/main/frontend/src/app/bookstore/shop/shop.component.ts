import {Component, OnInit} from '@angular/core';
import {ProductsService} from "../services/ProductsService";
import {Product} from "../models/product.model";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'shop',
    templateUrl: './shop.component.html',
    styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

    products: Product[];
    totalNumberOfProducts: number = 0;

    id: number;
    constructor(private productsService: ProductsService, private activatedRoute: ActivatedRoute ) {
    }

    ngOnInit() {
        this.activatedRoute.params.subscribe(params => {
            this.id = params['id'];
            this.productsService.getProductCountByCategoryId(this.id)
                .subscribe(
                    (count: any) => {
                        this.totalNumberOfProducts = count;
                        this.setPaginationOptions(this.totalNumberOfProducts, -1);
                        this.loadProducts();
                    },
                    (error) => console.log(error)
                );
        });

    }

    loadProducts() {
        this.productsService.getProductsByCategory(this.id, this.paginationCurrent)
            .subscribe(
                (products: any[]) => {
                    this.products = products;
                },
                (error) => console.log(error)
            );
    }


    paginationCurrent: number = 1;
    paginationLast: number;
    numberOfEventsPerPage: number = 20;

    setPaginationOptions(numberOfHits: number, currPage:number) {
        this.paginationLast = Math.ceil(numberOfHits/this.numberOfEventsPerPage);
        debugger;
        if(currPage != -1) this.paginationCurrent = currPage;
    }

    public get middlePages(): number[] {
        let middlePages: number[] = [];
        if (this.paginationCurrent > 1) {
            middlePages.push(this.paginationCurrent - 1);
        }
        middlePages.push(this.paginationCurrent);
        if (this.paginationCurrent < this.paginationLast) {
            middlePages.push(this.paginationCurrent + 1);
        }
        return middlePages;
    }


}
