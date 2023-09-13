package service;

import java.time.LocalDate;
import java.util.*;
import entities.Product;
import entities.ProductCategory;

public class Warehouse {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("12","phone",5, ProductCategory.ELECTRONICS, LocalDate.now(),LocalDate.now()));

        System.out.println("products: " + products);
    }
}
