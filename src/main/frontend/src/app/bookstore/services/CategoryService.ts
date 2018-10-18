import {HttpClient} from '@angular/common/http';
import {Injectable} from "@angular/core";

@Injectable()
export class CategoryService {

    constructor(private http: HttpClient) {
    }

    getCategoryCount() {
        return this.http.get("/api/getCategoryCount");
    }

    getCategoriesByPage(page) {
        return this.http.get("/api/categoriesByPage/"+page);
    }

}
