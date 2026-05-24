# 🏨 Hotel Room Booking API

A RESTful backend service for managing hotel rooms and reservations with user authentication, built with Java and Spring Boot.

## Tech Stack

- **Java 17**
- **Spring Boot** — application framework
- **Spring MVC** — REST layer
- **Spring Security** — authentication & access control
- **Spring Data JPA** — database access
- **PostgreSQL** — persistent storage
- **Maven** — build tool

## Features

- User registration and login
- Authenticated access to booking endpoints
- Manage hotel rooms (create, read, update, delete)
- Manage reservations (create, read, update, delete)
- Clean layered architecture: Controller → Service → Repository

## Project Structure

```
src/main/java/com/example/demo/
├── config/
│   └── SecurityConfig.java        # Spring Security configuration
├── controller/
│   ├── AuthController.java        # Registration & login
│   ├── RoomController.java        # Room endpoints
│   └── ReservationController.java # Reservation endpoints
├── service/
│   ├── UserService.java
│   └── ReservationService.java
├── repository/
│   ├── UserRepository.java
│   ├── RoomRepository.java
│   └── ReservationRepository.java
└── model/
    ├── User.java
    ├── Room.java
    └── Reservation.java
```

## API Endpoints

### Auth

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Login and get session |

### Rooms

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/rooms` | Get all rooms |
| GET | `/api/rooms/{id}` | Get room by ID |
| POST | `/api/rooms` | Create a new room |
| PUT | `/api/rooms/{id}` | Update room |
| DELETE | `/api/rooms/{id}` | Delete room |

### Reservations

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/reservations` | Get all reservations |
| GET | `/api/reservations/{id}` | Get reservation by ID |
| POST | `/api/reservations` | Create a new reservation |
| PUT | `/api/reservations/{id}` | Update reservation |
| DELETE | `/api/reservations/{id}` | Delete reservation |

## Getting Started

### Prerequisites

- Java 17+
- PostgreSQL
- Maven

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/DanilRein/demo.git
   cd demo
   ```

2. **Configure the database**

   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   The API will be available at `http://localhost:8080`

## Example Requests

**Register a user:**
```http
POST /auth/register
Content-Type: application/json

{
  "username": "john",
  "password": "secret123"
}
```

**Create a room:**
```http
POST /api/rooms
Content-Type: application/json

{
  "number": "101",
  "type": "single",
  "pricePerNight": 75.00
}
```

**Create a reservation:**
```http
POST /api/reservations
Content-Type: application/json

{
  "roomId": 1,
  "userId": 1,
  "checkIn": "2025-06-01",
  "checkOut": "2025-06-05"
}
```

## Planned Improvements

- [ ] JWT token-based authentication
- [ ] Input validation and global error handling
- [ ] Unit and integration tests
- [ ] Docker support
- [ ] API documentation with Swagger/OpenAPI

## Author

**Daniil Radevich** — Java Backend Developer  
[GitHub](https://github.com/DanilRein) · [Upwork](#)
