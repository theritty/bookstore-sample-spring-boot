export class Product {
    id: number;
    name: string;
    author: string;
    description: string;
    categoryId: number;
    price: number;
    discount: number;
    bestSellerPrd: boolean;
    newPrd: boolean;
    pictureUrl: string;
    remainingQuantity: number;

    constructor(id: number, name: string, author: string, description: string, categoryId: number, price: number, discount: number, bestSellerPrd: boolean, newPrd: boolean, pictureUrl: string, remainingQuantity: number) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
        this.discount = discount;
        this.bestSellerPrd = bestSellerPrd;
        this.newPrd = newPrd;
        this.pictureUrl = pictureUrl;
        this.remainingQuantity = remainingQuantity;
    }
}
