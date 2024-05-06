import { Product } from "./Product";

export interface Order {
    id: number;
    quantityOrder: number;
    product: Product;
}