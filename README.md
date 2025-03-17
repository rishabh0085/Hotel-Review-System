# Hotel Review System

The **Hotel Review System** is a robust application built with **Java and Spring Boot**, leveraging **Microservices Architecture** to create a scalable, modular, and efficient platform for users to submit, update, and view hotel reviews. This project incorporates essential features to ensure smooth operation, scalability, and reliability, such as **API Gateway, Eureka for Service Registry, Feign Client, and Config Server**. With these technologies, the system ensures seamless service discovery, dynamic load balancing, and high availability.

## Key Features
- **Microservices Architecture**: The application is composed of multiple independent services, each dedicated to a specific business domain (hotel details, user management, and ratings).
- **API Gateway**: The API Gateway serves as the entry point for all incoming requests, routing them to the appropriate microservices while simplifying client interactions with the system.
- **Eureka Service Registry**: The Eureka Server manages service discovery, allowing dynamic registration of services as they come online, and provides a seamless experience for scaling.
- **Feign Client**: Feign Client is used for easy inter-service communication, abstracting HTTP request handling and reducing boilerplate code.
- **Config Server**: A Config Server centralizes configuration management for all microservices, making it easier to maintain and update configuration settings across the system.
- **REST APIs**: Implemented RESTful APIs (**GET, POST, PUT, DELETE**) for managing hotel data, user information, and review ratings.
- **Postman API Testing**: Utilized Postman to thoroughly test and validate all API endpoints, ensuring they perform as expected.

## Core Microservices
- **ApiGateway**: Manages request routing and provides a unified entry point for all API calls.
- **ConfigServer**: Serves the centralized configuration settings for all microservices.
- **HotelService**: Handles hotel details, including creating, updating, and viewing hotel information.
- **RatingService**: Manages hotel reviews and ratings, allowing users to submit and view reviews.
- **ServiceRegistry**: Implements the Eureka Server for service discovery and registration.
- **UserService**: Manages user-related operations such as registration, login, and authentication.

## Technologies Used
- **Java**
- **Spring Boot**
- **Microservices Architecture**
- **Eureka (for Service Registry)**
- **Feign Client (for Inter-Service Communication)**
- **API Gateway (for Routing)**
- **Postman (for API Testing)**
- **REST APIs (for CRUD operations)**

This system is a great example of how to build a **reliable, scalable, and maintainable architecture** using modern microservices patterns with **Spring Boot**. Feel free to explore the repository, contribute, or provide feedback!

## Getting Started
### Prerequisites
Ensure you have the following installed:
- Java 17+
- Spring Boot
- MySQL/PostgreSQL (for database management)
- Postman (for testing APIs)
- Maven (for dependency management)

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/hotel-review-system.git
   ```
2. Navigate to the project directory:
   ```sh
   cd hotel-review-system
   ```
3. Start the **Config Server** first:
   ```sh
   cd ConfigServer
   mvn spring-boot:run
   ```
4. Start the **Eureka Service Registry**:
   ```sh
   cd ServiceRegistry
   mvn spring-boot:run
   ```
5. Start the remaining microservices (**ApiGateway, HotelService, RatingService, UserService**):
   ```sh
   mvn spring-boot:run
   ```

### API Endpoints
#### **Hotel Service**
- **Create Hotel**: `POST /hotels`
- **Get All Hotels**: `GET /hotels`
- **Get Hotel by ID**: `GET /hotels/{id}`
- **Update Hotel**: `PUT /hotels/{id}`
- **Delete Hotel**: `DELETE /hotels/{id}`

#### **Rating Service**
- **Submit Review**: `POST /ratings`
- **Get All Reviews**: `GET /ratings`
- **Get Ratings for a Hotel**: `GET /ratings/hotel/{id}`

#### **User Service**
- **Register User**: `POST /users`
- **Get All Users**: `GET /users`
- **Authenticate User**: `POST /users/auth`



