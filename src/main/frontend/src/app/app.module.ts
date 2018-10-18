import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import {ROUTING} from './/app-routing.module';
import {AppComponent} from './app.component';
import {ProductsService} from "./bookstore/services/ProductsService";
import {ShopComponent} from "./bookstore/shop/shop.component";
import {ProductDetailComponent} from "./bookstore/productDetails/productdetail.component";
import {CategoriesComponent} from "./bookstore/categories/categories.component";
import {CategoryService} from "./bookstore/services/CategoryService";
import {HeaderComponent} from "./bookstore/components/header/header.component";
import {FooterComponent} from "./bookstore/components/footer/footer.component";

@NgModule({
    declarations: [
        AppComponent,
        ShopComponent,
        ProductDetailComponent,
        CategoriesComponent,
        HeaderComponent,
        FooterComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        ROUTING
    ],
    providers: [
        ProductsService,
        CategoryService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
