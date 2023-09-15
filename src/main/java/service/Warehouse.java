package service;

import entities.Product;
import entities.ProductCategory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;

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
            productToUpdate.get().updateDateModified();
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

    // get products by category
    public List<Product> getProductsByCategory(ProductCategory category){
        return  getAllProducts().stream()
                .filter(pdt->pdt.getCategory()== category)
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    // get all products created after a given date. New products then last

    public List<Product> getProductsCreatedAfterDateSortedByNewest(LocalDateTime date){
        return getAllProducts().stream()
                .filter(product -> product.getDateCreated().isAfter(date))
                .sorted(Comparator.comparing(Product::getDateCreated).reversed())
                .collect(Collectors.toList());
    }


    // get all products modified after creation
    public List<Product> getProductsModifiedAfterCreation() {
        return products.stream()
                .filter(product -> product.getDateModified().isAfter(product.getDateCreated()))
                .collect(Collectors.toList());
    }
}
