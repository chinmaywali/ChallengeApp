# Challenge App 📝 

Welcome to the **Challenge App**! This is a Spring Boot application designed to manage and track monthly challenges. Whether it's hitting the gym, reading books, or taking on new adventures, Challenge App helps you stay on top of your goals.

## Features

- **Add Challenges**: Create new challenges with a specific month and description.
- **View Challenges**: Retrieve a list of all challenges or search for challenges by month.
- **Update Challenges**: Modify existing challenges by their unique ID.
- **Delete Challenges**: Remove challenges that are no longer needed.

## Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com.example.ChallengeApp/
│   │       ├── ChallengeAppApplication.java   // Main application entry point
│   │       ├── Challenge.java                 // Challenge entity with attributes
│   │       ├── ChallengeController.java       // REST Controller for handling HTTP requests
│   │       └── ChallengeService.java          // Service layer for business logic
│   └── resources/
│       └── application.properties             // Application configurations
└── test/
    └── java/
        └── com.example.ChallengeApp/          // Unit and integration tests
```

## API Endpoints

### Get All Challenges

```http
GET /challenges
```

- **Description**: Retrieve a list of all challenges.
- **Response**:
  - `200 OK`: Returns a list of all challenges.
  - `[]`: Empty array if no challenges are found.

### Get Challenge by Month

```http
GET /challenges/{month}
```

- **Description**: Retrieve a specific challenge by its month.
- **Path Variable**: 
  - `month` (String): The month of the challenge to retrieve.
- **Response**:
  - `200 OK`: Returns the challenge for the specified month.
  - `404 NOT FOUND`: If no challenge is found for the given month.

### Add a New Challenge

```http
POST /challenges
```

- **Description**: Add a new challenge.
- **Request Body** (JSON):
  ```json
  {
    "month": "March",
    "description": "Read books"
  }
  ```
- **Response**:
  - `200 OK`: Challenge added successfully.
  - `404 NOT FOUND`: Challenge not added due to an error.

### Update a Challenge

```http
PUT /challenges/{id}
```

- **Description**: Update an existing challenge by its ID.
- **Path Variable**:
  - `id` (Long): The ID of the challenge to update.
- **Request Body** (JSON):
  ```json
  {
    "month": "April",
    "description": "Go hiking"
  }
  ```
- **Response**:
  - `200 OK`: Challenge updated successfully.
  - `404 NOT FOUND`: If no challenge is found with the specified ID.

### Delete a Challenge

```http
DELETE /challenges/{id}
```

- **Description**: Delete a challenge by its ID.
- **Path Variable**:
  - `id` (Long): The ID of the challenge to delete.
- **Response**:
  - `200 OK`: Challenge deleted successfully.
  - `404 NOT FOUND`: If no challenge is found with the specified ID.

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/challenge-app.git
   ```
2. **Navigate to the Project Directory**:
   ```bash
   cd challenge-app
   ```
3. **Build and Run the Application**:
   ```bash
   ./mvnw spring-boot:run
   ```
## Testing the API with Postman

1. **Install Postman**: [Download here](https://www.postman.com/downloads/).

2. **Test Endpoints**:

   - **Get All Challenges**
     - `GET /challenges`
     - URL: `http://localhost:8080/challenges`

   - **Get Challenge by Month**
     - `GET /challenges/{month}`
     - Replace `{month}` with the desired month.

   - **Add Challenge**
     - `POST /challenges`
     - URL: `http://localhost:8080/challenges`
     - Headers: `Content-Type: application/json`
     - Body:
       ```json
       {
         "month": "April",
         "description": "Go hiking"
       }
       ```

   - **Update Challenge**
     - `PUT /challenges/{id}`
     - Replace `{id}` with the challenge ID.
     - Body:
       ```json
       {
         "month": "May",
         "description": "Learn a new skill"
       }
       ```

   - **Delete Challenge**
     - `DELETE /challenges/{id}`
     - Replace `{id}` with the challenge ID.




## Technologies Used

- **Java**: Core programming language.
- **Spring Boot**: Framework for building the application.
- **Maven**: Dependency management.
- **RESTful APIs**: For client-server communication.

## Future Enhancements

- **Authentication**: Add user authentication for personalized challenge tracking.
- **Database Integration**: Persist challenges in a database.
- **UI Interface**: Develop a web interface for easier interaction.

## Contribution

Contributions are welcome! Feel free to fork the repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

---

Happy Challenging! 🚀 



