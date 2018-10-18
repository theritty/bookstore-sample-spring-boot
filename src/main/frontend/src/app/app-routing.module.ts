import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ShopComponent} from "./bookstore/shop/shop.component";
import {ProductDetailComponent} from "./bookstore/productDetails/productdetail.component";
import {CategoriesComponent} from "./bookstore/categories/categories.component";

const routes: Routes = [
    { path: 'categories', component: CategoriesComponent },
    { path: 'shop/:id', component: ShopComponent },
    { path: '', redirectTo: '/categories', pathMatch: 'full' },
    { path: 'product/:id', component: ProductDetailComponent },

];

export const ROUTING: ModuleWithProviders = RouterModule.forRoot(routes);
