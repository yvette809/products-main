package org.example;

import entities.Product;
import entities.ProductCategory;
import org.junit.jupiter.api.Test;
import service.Warehouse;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class WarehouseTest {
    Warehouse warehouse = new Warehouse();

    @Test
    public void testAddProduct(){

        Product product1 = new Product("laptop",6,ProductCategory.ELECTRONICS);
          warehouse.addNewProduct(product1);
          // check length of array
          List<Product> products = warehouse.getAllProducts();
         assertEquals(1, products.size());

         // check for right field
        Product addedProduct = products.get(0);
        assertEquals("laptop", addedProduct.getName());
        assertEquals(6,addedProduct.getRating());
        assertEquals(ProductCategory.ELECTRONICS,addedProduct.getCategory());

    }
    @Test
    public void testEditProduct(){
        Product product = new Product("laptop",6,ProductCategory.ELECTRONICS);
        warehouse.addNewProduct(product);
        warehouse.editProduct(1,"New laptop",9,null);
        Optional<Product> editedProduct = warehouse.getProductById(1);
        assertTrue(editedProduct.isPresent());
        assertEquals("New laptop", editedProduct.get().getName());
        assertEquals(9, editedProduct.get().getRating());

    }

}