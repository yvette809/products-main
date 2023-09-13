package entities;
import java.util.*;
import java.time.LocalDate;

public class Product {


    private  String name;
    private String productId;
    private int rating;

    private ProductCategory category;

    private LocalDate dateCreated;

    private LocalDate dateModified;

    public Product(String productId, String name, int rating, ProductCategory category, LocalDate dateCreated, LocalDate dateModified){
        this.productId = productId;
        this.name = name;
        this.rating = rating;
        this.category = category;
        this.dateCreated = LocalDate.now();
        this.dateModified = LocalDate.now();
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }

    public ProductCategory getCategory() {
        return category;
    }
    public LocalDate getDateCreated() {
        return dateCreated;
    }
    public LocalDate getDateModified() {
        return dateModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productId='" + productId + '\'' +
                ", rating=" + rating +
                ", category=" + category +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }


}


