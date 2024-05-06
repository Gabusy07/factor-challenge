import { Order } from "./Order";

export interface Cart {
    id: number;
    totalPrice: number;
    initialDate: string;
    productOrders: Order[];
    active: boolean;
}