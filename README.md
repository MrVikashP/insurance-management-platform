# Insurance Management Platform
The Insurance Management Platform is a Spring Boot application that allows users to manage insurance policies, clients, and claims. The platform provides RESTful APIs for CRUD operations on clients, insurance policies, and claims. The application uses an embedded database Apache Derby to store data.

## Table of Contents
- Installation
- Usage
- Endpoints
- Conclusion

### Installation
To build and run the application, follow these steps:

1. Clone the repository to your local machine:
``` git clone https://github.com/username/insurance-management-platfrom.git ```

2. Change directory to the project root:
``` cd insurance-management-platform ```

3. Build the application using Maven:
``` mvn clean package ```

4. Run the application using the Spring Boot Maven plugin:
``` mvn spring-boot:run ```

5. The application should start running on http://localhost:8080.

6. To run the application locally, you need to have Java 11 or later installed on your machine (JAVA 18 used by me). 
You can check your Java version by running the command: 
``` java --version ```

7. You also need to have Maven installed to build and run the application. 
You can check your Maven version by running the command:
``` mvn --version ```

### Usage
To use the application, you can use a tool like Postman or cURL to make requests to the API endpoints. See the Endpoints section below for a list of available endpoints.

### Endpoints
The following endpoints are available in the application:
#### Clients
Represents a client with properties such as name, date of birth, address, and contact information.
- GET /api/clients: Fetch all clients.
- GET /api/clients/{id}: Fetch a specific client by ID.
- POST /api/clients: Create a new client.
- PUT /api/clients/{id}: Update a client's information.
- DELETE /api/clients/{id}: Delete a client.
#### Insurance Policies
Represents an insurance policy with properties like policy number, type, coverage amount, premium, start date, and end date. 
Each policy should be associated with a client.
- GET /api/policies: Fetch all insurance policies.
- GET /api/policies/{id}: Fetch a specific insurance policy by ID.
- POST /api/policies: Create a new insurance policy.
- PUT /api/policies/{id}: Update an insurance policy's information.
- DELETE /api/policies/{id}: Delete an insurance policy.
#### Claims
Represents an insurance claim with properties like claim number, description, claim date, and claim status. 
Each claim should be associated with an insurance policy
- GET /api/claims: Fetch all claims.
- GET /api/claims/{id}: Fetch a specific claim by ID.
- POST /api/claims: Create a new claim.
- PUT /api/claims/{id}: Update a claim's information.
- DELETE /api/claims/{id}: Delete a claim.

### Conclusion
This project is a simple yet useful implementation of an insurance management system. It demonstrates the power and flexibility of Spring Boot and Spring Data JPA in creating RESTful APIs for managing data in a database.
