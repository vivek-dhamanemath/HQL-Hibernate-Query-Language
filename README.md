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

```
## HQL Queries

HQL (Hibernate Query Language) is similar to SQL but operates on the entity objects rather than directly on database tables. Here are some examples of HQL queries you can use with the `Product` entity:

### Select All Products

```java
String hql = "FROM Product";
Query query = session.createQuery(hql);
List<Product> products = query.list();
```

### Select Products by Brand

```java
String hql = "FROM Product P WHERE P.productBrand = :brand";
Query query = session.createQuery(hql);
query.setParameter("brand", "BrandName");
List<Product> products = query.list();
```

### Update Product Price

```java
String hql = "UPDATE Product set productPrice = :price WHERE productId = :id";
Query query = session.createQuery(hql);
query.setParameter("price", 1000);
query.setParameter("id", 1);
int result = query.executeUpdate();
```

### Delete Product

```java
String hql = "DELETE FROM Product WHERE productId = :id";
Query query = session.createQuery(hql);
query.setParameter("id", 1);
int result = query.executeUpdate();
```

## Running the Project

1. Ensure you have a Hibernate configuration file (`hibernate.cfg.xml`) with the correct database connection settings.
2. Create a Hibernate utility class to manage the session factory.
3. Write a main class to demonstrate the HQL queries.

## Conclusion

This project provides a basic example of using Hibernate HQL with a `Product` entity. You can extend this project by adding more entities and complex queries as needed.
