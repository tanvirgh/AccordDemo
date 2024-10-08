## Spring boot crud api project

## Technologies Used

- **Spring Boot**: The core framework
- **Spring Data JPA**: For database interactions
- **H2 Database**: In-memory database for development and testing
- **Maven**: For project management and dependency management
- **Lombok**: To reduce boilerplate code
- **Swagger**: For API documentation


## Getting Started

### Prerequisites

- Java 17 
- Maven 3.6 or higher
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Clone the Repository


git clone [https://github.com/tanvirgh/AccordDemo.git]


### Build the Project
Use Maven to build the project:


mvn clean install


### Run the Application
You can run the application using the following command:

mvn spring-boot:run

### API Endpoints
Here are some example API endpoints for a user resource:

Create User
Endpoint: POST /api/v1/users/createUser

Get All Users
Endpoint: GET /api/v1/users/getAllUsers

Get User By Id

Endpoint: GET /api/v1/users/getUser/{id}

Update User
Endpoint: PUT /api/v1/users/updateUser/{id}

Delete User
Endpoint: DELETE /api/v1/users/deleteUser/{id}

Logging
Request and response logs are stored in the logs directory under the project root. Ensure the directory exists, or it will be created automatically when you run the application.
