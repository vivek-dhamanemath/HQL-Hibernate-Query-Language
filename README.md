
# Hibernate HQL Project

This project demonstrates the use of Hibernate Query Language (HQL) with a simple `Product` entity.

## Project Structure

- `src/main/java/com/hibernate/HQL/Hibernate_HQL/Product.java`: Contains the `Product` entity class.

## Product Entity

The `Product` class is a simple entity with the following fields:
- `productId`: The unique identifier for the product.
- `productName`: The name of the product.
- `productBrand`: The brand of the product.
- `productPrice`: The price of the product.

```java
package com.hibernate.HQL.Hibernate_HQL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int productId;
    private String productName;
    private String productBrand;
    private int productPrice;
    
    // Getters and setters
    // ...existing code...
    
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", productBrand=" + productBrand
                + ", productPrice=" + productPrice + "]";
    }
}
