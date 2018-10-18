export class Category {
    id: number;
    name: string;
    pictureUrl: string;

    constructor(id: number, name: string, pictureUrl: string) {
        this.id = id;
        this.name = name;
        this.pictureUrl = pictureUrl;
    }
}
