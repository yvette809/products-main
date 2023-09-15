package service;

import entities.Product;
import entities.ProductCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Warehouse {

    public final List<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }

    public boolean addNewProduct(Product product) {
        if (product.getName().isEmpty()) {
            System.out.println("Product must have a name");
            return false;
        }

        products.add(product);
        System.out.println("Product successfully added");
        return true;
    }

    public Optional<Product> editProduct(int productId, String newName, int newRating, ProductCategory newCategory) {
        Optional<Product> productToUpdate = products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();

        if (productToUpdate.isPresent()) {
            productToUpdate.get().setName(newName);
            productToUpdate.get().setRating(newRating);
            productToUpdate.get().setProductCategory(newCategory);
            System.out.println("Product edited successfully");
        } else {
            System.out.println("product not found for editing");
        }

        return productToUpdate;
    }

    // get all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    // get product by id
    public Optional<Product> getProductById(int productId) {
        return products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();
    }
}
