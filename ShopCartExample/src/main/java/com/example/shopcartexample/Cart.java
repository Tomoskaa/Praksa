package com.example.shopcartexample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void printByCategory(String category) {
        List<Product> caegoryProducts = this.products.stream().filter(c -> c.getCategory().equals(category))
                .collect(Collectors.toList());
        caegoryProducts.forEach(c -> System.out.println(c.getName() + " " + c.getPrice()));
    }

    //public void getCheapestN(int n) {
    public List<Product> getCheapestN(int n) {
        List<Product> sortByPrice = this.products.stream()
                .sorted((p1, p2) -> {
                    if(p1.getPrice() == p2.getPrice())
                        return p1.getName().compareTo(p2.getName());
                    else if(p1.getPrice() > p2.getPrice())
                        return 1;
                    else
                        return -1;
                }).collect(Collectors.toList());

        return sortByPrice.stream().limit(n).collect(Collectors.toList());
//        List<Product> productsByPrice = sortByPrice.stream().limit(n).collect(Collectors.toList());
//        productsByPrice.forEach(p -> System.out.println(p.getName() + " " + p.getPrice() + " " + p.getCategory()));
    }


    public float getTotalPrice() {
        float totalPrice = 0;
        for (Product p : products) {
            totalPrice += (p.getPrice() * p.getQuantity());
        }
        return totalPrice;
    }

    public void printPaymentReceipt() {
        System.out.print("Име на продукт" + "\t");
        System.out.print("Количина" + "\t");
        System.out.print("Единечна цена" + "\t");
        System.out.println("Цена");
        for (Product p : products) {
            System.out.print(p.getName() + "\t");
            System.out.print(p.getQuantity() + "\t");
            System.out.print(p.getPrice() + "\t");
            System.out.println(p.getPrice() * p.getQuantity() + "\t");
        }
        System.out.println();
        System.out.println("Вкупна цена    : " + this.getTotalPrice());
        System.out.println("Вкупна цена со фиксен 18% ДДВ   : " + (this.getTotalPrice() + (this.getTotalPrice() * 18) / 100));
    }
}
