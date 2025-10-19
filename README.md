# Product Management API with GraphQL

This repository contains a **Spring Boot** application that exposes a **GraphQL API** for managing products. The API allows you to create, read, update, and delete products in a database, demonstrating how to work with GraphQL in a Java backend.

## Features

- Retrieve all products or filter by category.
- Create new products.
- Update existing products with **partial updates**.
- Delete products by ID.
- Uses **GraphQL** for flexible queries and mutations.
- Input validation and non-nullable fields handled properly.

## Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Spring GraphQL**
- **ModelMapper** for DTO mapping
- **JPA / Hibernate** for database access
- **H2 / MySQL** (configurable) as database
- **Lombok** for boilerplate code reduction

## GraphQL Schema

```graphql
type Product {
  id: ID!
  name: String!
  category: String!
  price: Float!
  stock: Int!
}

input ProductInput {
  name: String
  category: String
  price: Float
  stock: Int
}

type Query {
  getAllProducts: [Product!]!
  getProductsByCategory(category: String!): [Product!]!
}

type Mutation {
  createProduct(input: ProductInput!): Product!
  updateProduct(id: ID!, input: ProductInput!): Product!
  deleteProduct(id: ID!): Boolean!
}
```

## Prerequisites

- Java 17 or higher
- Maven (for building the project)
- Git (for cloning the repository)
- Optional: MySQL (if using MySQL as the database instead of H2)

## Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/NipunBasnayake/SpringBoot-GraphQL.git
cd product-graphql-api
```

### 2. Configure the database

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/product_db
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
```

### 3. Build and run the application
```bash
./mvnw clean install
./mvnw spring-boot:run
```

### 4. Access GraphQL playground
<a href="http://localhost:8080/graphiql" target="_blank">http://localhost:8080/graphiql</a>

_Note: Ensure the application is running before accessing the GraphiQL interface._


