import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CategoryService} from "../services/CategoryService";
import {Category} from "../models/category.model";

@Component({
    selector: 'categories',
    templateUrl: './categories.component.html',
    styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

    constructor(private categoryService: CategoryService ) {
    }

    ngOnInit() {
        this.categoryService.getCategoryCount()
            .subscribe(
                (count: any) => {
                    this.totalNumberOfCategories = count;
                    this.setPaginationOptions(this.totalNumberOfCategories, -1);
                    this.loadProducts();
                },
                (error) => console.log(error)
            );
    }


    categories: Category[];
    totalNumberOfCategories: number = 0;
    loadProducts() {
        this.categoryService.getCategoriesByPage(this.paginationCurrent)
            .subscribe(
                (categories: any[]) => {
                    this.categories = categories;
                },
                (error) => console.log(error)
            );
    }



    paginationCurrent: number = 1;
    paginationLast: number;
    numberOfEventsPerPage: number = 20;

    setPaginationOptions(numberOfHits: number, currPage:number) {
        this.paginationLast = Math.ceil(numberOfHits/this.numberOfEventsPerPage);
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
