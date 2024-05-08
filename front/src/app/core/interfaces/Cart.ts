import { Order } from "./Order";

export interface Cart {
    id: number;
    totalPrice: number;
    initialDate: string;
    totalDiscount: number;
    productOrders: Order[];
    active: boolean;
}