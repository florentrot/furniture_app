# Furniture Shop API

This is a simple REST API for managing products in a furniture shop. The project includes features such as exception handling using aspects, Swagger for API documentation, and a database connection using Spring Data JPA.

## Features

- **REST Controller**: Provides endpoints for CRUD operations on products.
- **Exception Handling**: Uses aspects to handle exceptions globally.
- **Swagger**: Integrated Swagger UI for API documentation.
- **Database Connection**: Connects to a MySQL database using Spring Data JPA.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Swagger**
- **Lombok**
- **Gradle**

## Getting Started

### Prerequisites

- Java 11 or higher
- Gradle
- MySQL

### Setup

1. **Clone the repository**:
    ```sh
    git clone https://github.com/florentrot/furniture_app.git
    cd furniture_app
    ```

2. **Configure the database**:
   Update the `src/main/resources/application.properties` file with your MySQL database credentials.

3. **Build the project**:
    ```sh
    ./gradlew build
    ```

4. **Run the application**:
    ```sh
    ./gradlew bootRun
    ```

### Accessing Swagger UI

Once the application is running, you can access the Swagger UI at:

## Endpoints

- **GET /products**: Retrieve all products
- **POST /products**: Create a new product
- **PUT /products/{id}**: Update an existing product
- **DELETE /products/{id}**: Delete a product

## License

This project is licensed under the MIT License.
