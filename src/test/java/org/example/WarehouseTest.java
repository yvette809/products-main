package org.example;

import entities.Product;
import entities.ProductCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import service.Warehouse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


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

@Test
    public void testGetProductsCreatedAfterDateSortedByNewest(){
    LocalDateTime dateToCompare = LocalDateTime.of(2023, 9, 11, 0, 0);
        List<Product> productsCreatedAfterDate = warehouse.getProductsCreatedAfterDateSortedByNewest(dateToCompare);
        assertEquals(6, productsCreatedAfterDate.size());

}

@Test
    public void testGetProductsModifiedAfterCreation(){
        warehouse.editProduct(1,"old laptop",7,ProductCategory.ELECTRONICS);
        warehouse.editProduct(3,"ledger",7,ProductCategory.BOOKS);
        List<Product> productsModifiedAfterCreation = warehouse.getProductsModifiedAfterCreation();
        assertEquals(2, productsModifiedAfterCreation.size());
        assertEquals("old laptop", productsModifiedAfterCreation.get(0).getName());
        assertEquals(7, productsModifiedAfterCreation.get(1).getRating());


}

@Test
    public void testGetCategoriesWithProducts(){
        Set<ProductCategory> categoriesWithProducts = warehouse.getCategoriesWithProducts();
        assertEquals(3,categoriesWithProducts.size());
        assertTrue(categoriesWithProducts.contains(ProductCategory.ANIMALS));
        assertTrue(categoriesWithProducts.contains(ProductCategory.ELECTRONICS));
        assertTrue(categoriesWithProducts.contains(ProductCategory.OTHER));

}
@Test
    public void testGetProductCountByCategory(){
        Map<ProductCategory,Long> productsCountByCategory = warehouse.getProductCountByCategory();
    // Assert the counts for specific categories
    assertEquals(2, productsCountByCategory.get(ProductCategory.ELECTRONICS));
    assertEquals(2, productsCountByCategory.get(ProductCategory.ANIMALS));

}

@Test
    public void testGetProductCountByStartingLetter(){
    Map<Character, Long> productsCountByStartingLetter = warehouse.getProductCountByStartingLetter();
    assertEquals(1, productsCountByStartingLetter.get('B'));
    assertEquals(1, productsCountByStartingLetter.get('C'));
    assertEquals(1, productsCountByStartingLetter.get('d'));
    System.out.println(productsCountByStartingLetter);
}
}