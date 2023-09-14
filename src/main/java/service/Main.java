package service;

import entities.Product;
import entities.ProductCategory;
import java.util.List;
import java.util.Optional;

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
        warehouse.addNewProduct(product1);
        warehouse.addNewProduct(product2);
        warehouse.addNewProduct(product3);
        warehouse.addNewProduct(product4);
        warehouse.addNewProduct(product5);
        warehouse.addNewProduct(product6);
        warehouse.addNewProduct(product7);
        warehouse.addNewProduct(product8);

// edit product

        warehouse.editProduct(1, "trousers", 5, ProductCategory.CLOTHING);

        // Print the updated products
        //warehouse.products.forEach(product -> System.out.println("Product: " + product));



        for (Product product : warehouse.products) {
            System.out.println("Product: " + product);
        }

        // get all products
        List <Product> getAllProducts =  warehouse.getAllProducts();
        System.out.println("The products are: " + getAllProducts);

        // get product by id
        Optional<Product> getPdtById =  warehouse.getPdtById(3);
        System.out.println("The product by Id is :" + getPdtById);

    }


}


