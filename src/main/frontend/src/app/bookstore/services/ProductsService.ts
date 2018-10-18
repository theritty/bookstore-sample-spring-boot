import {HttpClient} from '@angular/common/http';
import {Injectable} from "@angular/core";

@Injectable()
export class ProductsService {

    constructor(private http: HttpClient) {
    }

    getProduct(id) {
        return this.http.get("/api/product/"+id);
    }

    getProductsByCategory(categoryid, page) {
        return this.http.get("/api/productsByCategory/"+categoryid+"/"+page);
    }

    getProductCountByCategoryId(categoryid) {
        return this.http.get("/api/getProductCountByCategoryId/"+categoryid);
    }


}
