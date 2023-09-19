package org.example;

import entities.Product;
import entities.ProductCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import service.Warehouse;
import java.util.List;
import java.util.Optional;



class WarehouseTest {
    private Warehouse warehouse;
    @BeforeEach
            public void setUp(){
         warehouse = new Warehouse();
        Product product1 = new Product("laptop",6,ProductCategory.ELECTRONICS);
        Product product2 = new Product("Ball",7,ProductCategory.OTHER);
        Product product3 = new Product("dog",5,ProductCategory.ANIMALS);
        Product product4 = new Product("smart phone",4,ProductCategory.ELECTRONICS);
        Product product5 = new Product("Cat",8,ProductCategory.ANIMALS);
        Product product6 = new Product("fame",3,ProductCategory.OTHER);

        warehouse.addNewProduct(product1);
        warehouse.addNewProduct(product2);
        warehouse.addNewProduct(product3);
        warehouse.addNewProduct(product4);
        warehouse.addNewProduct(product5);
        warehouse.addNewProduct(product6);

    }


    @Test
    public void testAddProduct(){
          // check length of array
          List<Product> products = warehouse.getAllProducts();
         assertEquals(6, products.size());

         // check for right field
        Product addedProduct = products.get(0);
        assertEquals("laptop", addedProduct.getName());
        assertEquals(6,addedProduct.getRating());
        assertEquals(ProductCategory.ELECTRONICS,addedProduct.getCategory());

    }
    @Test
    public void testEditProduct(){
        warehouse.editProduct(1,"New laptop",9,null);
        Optional<Product> editedProduct = warehouse.getProductById(1);
        assertTrue(editedProduct.isPresent());
        assertEquals("New laptop", editedProduct.get().getName());
        assertEquals(9, editedProduct.get().getRating());

    }
@Test
    public void testGetAllProducts(){
    List<Product> products = warehouse.getAllProducts();
    assertEquals(6, products.size());
    assertEquals("Ball", products.get(1).getName());
   assertEquals(5,products.get(2).getRating());

}

@Test
    public void testGetProductById(){
        Optional<Product> foundProduct = warehouse.getProductById(2);
        assertTrue(foundProduct.isPresent());
        assertEquals("Ball", foundProduct.get().getName());
        assertEquals(7, foundProduct.get().getRating());
        assertEquals(ProductCategory.OTHER, foundProduct.get().getCategory());
}

@Test
    public void testGetProductsByCategory(){
        List<Product> electronicProducts = warehouse.getProductsByCategory(ProductCategory.ELECTRONICS);
        assertEquals(2, electronicProducts.size());
        assertEquals("laptop", electronicProducts.get(0).getName());
        assertEquals("smart phone", electronicProducts.get(1).getName());
}
}