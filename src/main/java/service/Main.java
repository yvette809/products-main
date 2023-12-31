package service;

import entities.Product;
import entities.ProductCategory;

import java.util.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Product product1 = new Product("phone", 3, ProductCategory.ELECTRONICS);
        Product product2 = new Product("calculator", 3, ProductCategory.ELECTRONICS);
        Product product3 = new Product("shirt", 6, ProductCategory.CLOTHING);
        Product product4 = new Product("Novel", 4, ProductCategory.BOOKS);
        Product product5 = new Product("frames", 7, ProductCategory.BOOKS);
        Product product6 = new Product("Scooter", 8, ProductCategory.OTHER);
        Product product7 = new Product("Pen", 3, ProductCategory.OTHER);
        Product product8 = new Product("skirt", 9, ProductCategory.CLOTHING);
        Product product9 = new Product("Bag", 6, ProductCategory.OTHER);
        warehouse.addNewProduct(product1);
        warehouse.addNewProduct(product2);
        warehouse.addNewProduct(product3);
        warehouse.addNewProduct(product4);
        warehouse.addNewProduct(product5);
        warehouse.addNewProduct(product6);
        warehouse.addNewProduct(product7);
        warehouse.addNewProduct(product8);
        warehouse.addNewProduct(product9);


// edit product

        warehouse.editProduct(1, "tracksuits", 6, ProductCategory.CLOTHING);
        warehouse.editProduct(2, "machine", 6, ProductCategory.ELECTRONICS);

        // Print the updated products
        //warehouse.products.forEach(product -> System.out.println("Product: " + product));


        for (Product product : warehouse.products) {
            System.out.println("Product: " + product);
        }

        // get all products
        List<Product> getAllProducts = warehouse.getAllProducts();
        System.out.println("The products are: " + getAllProducts);

        // get product by id
        Optional<Product> getPdtById = warehouse.getProductById(3);
        System.out.println("The product by Id is :" + getPdtById);

        // get product by category

        ProductCategory category = ProductCategory.OTHER;

        List<Product> productsInCategory = warehouse.getProductsByCategory((category));
        for (Product pdt : productsInCategory)
            System.out.println("The products by category are: " + pdt);

        // get products created after a given date
        LocalDateTime dateToCompare = LocalDateTime.of(2023, 9, 15, 0, 0); // Replace with the desired date

        List<Product> productsCreatedAfterDate = warehouse.getProductsCreatedAfterDateSortedByNewest(dateToCompare);

        // Print the products created after the specified date, sorted by newest
        for (Product product : productsCreatedAfterDate) {
            System.out.println("Products created after a certain date are: " + product);
        }

        // get products modified after creation

        List<Product> getModifiedProducts = warehouse.getProductsModifiedAfterCreation();
        for (Product product : getModifiedProducts) {
            System.out.println("The modified products are: " + product);
        }

        // get categories with products

        Set<ProductCategory> getCategory = warehouse.getCategoriesWithProducts();
        for (ProductCategory cat : getCategory) {
            System.out.println("The categories are: " + cat);
        }

        // get products in a given category
        Map<ProductCategory, Long> productCountByCategory = warehouse.getProductCountByCategory();

        // Print the number of products in each category
        for (Map.Entry<ProductCategory, Long> entry : productCountByCategory.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Product Count: " + entry.getValue());
        }

        // get product map

        Map<Character, Long> productCountByStartingLetter = warehouse.getProductCountByStartingLetter();

        // Print the count of products for each starting letter
        for (Map.Entry<Character, Long> entry : productCountByStartingLetter.entrySet()) {
            System.out.println("Starting Letter: " + entry.getKey() + ", Product Count: " + entry.getValue());
        }
    }


}


