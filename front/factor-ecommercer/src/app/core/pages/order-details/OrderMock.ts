import { Order } from "../../interfaces/Order";

export const orderMock: Order[] = [
    {
        id: 1,
        quantityOrder: 10,
        product: {
            id: 2,
            name: "Google pixel",
            description: "Captura fotos increíbles, disfruta de un rendimiento fluido, y mantén tu información segura con el Pixel 6 Pro. Su cámara triple avanzada, procesador Google Tensor personalizado, batería de larga duración y elegante diseño lo convierten en la mejor opción del mercado. ¡No te pierdas la oportunidad de tenerlo!",
            stock: 5,
            code: null,
            price: 2,
            image: "../assets/products/images (2).jpg"
        }
    },
    {
        id: 1,
        quantityOrder: 1,
        product: {
            id: 2,
            name: "Google pixel",
            description: "Captura fotos increíbles, disfruta de un rendimiento fluido, y mantén tu información segura con el Pixel 6 Pro. Su cámara triple avanzada, procesador Google Tensor personalizado, batería de larga duración y elegante diseño lo convierten en la mejor opción del mercado. ¡No te pierdas la oportunidad de tenerlo!",
            stock: 5,
            code: null,
            price: 4,
            image: "../assets/products/images (2).jpg"
        }
    },
    {
        id: 6,
        quantityOrder: 2,
        product: {
            id: 3,
            name: "camisa",
            description: "camisa blanca",
            stock: 5,
            code: null,
            price: 1,
            image: "/assets/products/images.jpg"
        }
    },
    {
        id: 3,
        quantityOrder: 1,
        product: {
            id: 3,
            name: "camisa",
            description: "camisa blanca",
            stock: 5,
            code: null,
            price: 4,
            image: "/assets/products/images.jpg"
        }
    }
];