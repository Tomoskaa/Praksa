package com.example.shopcartexample;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args)
    {
        /* create empty list for getCheapestN(int n) method */
        List<Product> cartList = new ArrayList<>();

        /* creates new products with product name, category, quantity and price */
        Product product1 = new Product("Apple MacBook Pro 13", "Laptop", 1, 99999.00);
        Product product2 = new Product("Samsung Galaxy Z", "Smartphone", 2, 110000.00);
        Product product3 = new Product("Xiaomi Mi Watch", "Smartwatch", 3, 12000.00);
        Product product4 = new Product("Samsung Galaxy Tab A", "Tablet", 5, 8500.00);

        Cart cart = new Cart();

        /* add the product to the cart */
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);

        System.out.println("Продукти од категорија: ");
        cart.printByCategory("Laptop");
        System.out.println();

        System.out.println("Најевтини продукти: ");
        cartList = cart.getCheapestN(2);
        cartList.forEach(c -> System.out.println(c.getName() + " " + c.getPrice() + " " + c.getCategory()));
        System.out.println();

        /* test add new product to the cart */
        cart.addProduct(new Product("Iphone 13 Pro", "Smartphone", 1, 70000.00));

        System.out.println("Сума од цените на производите во кошничка: ");
        double totalPrice = cart.getTotalPrice();
        System.out.println(totalPrice);
        System.out.println();

        /* print all details for shopping cart */
        cart.printPaymentReceipt();
    }
}

/*

output:

Продукти од категорија:
Apple MacBook Pro 13 99999.0

Најевтини продукти:
Samsung Galaxy Tab A 8500.0 Tablet
Xiaomi Mi Watch 12000.0 Smartwatch

Сума од цените на производите во кошничка:
468499.0

Име на продукт	Количина	Единечна цена	Цена
Apple MacBook Pro 13	1	99999.0	99999.0
Samsung Galaxy Z	2	110000.0	220000.0
Xiaomi Mi Watch	3	12000.0	36000.0
Samsung Galaxy Tab A	5	8500.0	42500.0
Iphone 13 Pro	1	70000.0	70000.0

Вкупна цена    : 468499.0
Вкупна цена со фиксен 18% ДДВ   : 552828.8

 */
