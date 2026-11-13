# ✈️ Wanderly – Travel Planner

**Plan Smarter. Travel Better. Explore More.**

Wanderly is a Java-based Travel Planner web application designed to make organizing trips easier and more convenient. It allows users to create, manage, and organize their travel plans through a simple and user-friendly interface.

Built using **Java, Spring Boot, Thymeleaf, and MySQL**, Wanderly demonstrates backend development, database management, and server-side web application development.

---

## 🌍 About the Project

Planning a trip involves managing destinations, travel dates, and budgets. Wanderly provides a centralized platform where users can organize their travel details and manage their planned journeys.

The application follows the Spring Boot architecture and uses MySQL for persistent data storage.

## ✨ Features

- **Trip Management:** Create and manage travel plans.
- **Trip Details:** Store trip titles, destinations, start dates, and end dates.
- **Budget Management:** Add and maintain estimated trip budgets.
- **Trip Overview:** View your planned trips in one place.
- **Database Integration:** Store trip information using MySQL.
- **User-Friendly Interface:** Navigate through a clean and organized web interface.
- **Responsive Styling:** Modern CSS-based application design.

## 🛠️ Technology Stack

| Category | Technologies |
|---|---|
| Programming Language | Java |
| Backend Framework | Spring Boot |
| Frontend | HTML, CSS, Thymeleaf |
| Database | MySQL |
| ORM | Spring Data JPA, Hibernate |
| Build Tool | Maven |
| IDE | Visual Studio Code |
| Version Control | Git & GitHub |

## 📂 Project Structure

```text
travel-planner/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── TravelPlanner/
│       │       ├── controller/
│       │       │   ├── HomeController.java
│       │       │   └── TripController.java
│       │       │
│       │       ├── entity/
│       │       │   └── Trip.java
│       │       │
│       │       ├── repository/
│       │       │   └── TripRepository.java
│       │       │
│       │       ├── service/
│       │       │   └── TripService.java
│       │       │
│       │       └── HelloworldApplication.java
│       │
│       └── resources/
│           ├── static/
│           │   └── style.css
│           │
│           ├── templates/
│           │   ├── index.html
│           │   ├── trip-form.html
│           │   └── trips.html
│           │
│           └── application.properties
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

## ⚙️ Getting Started

Follow these steps to run Wanderly locally.

### 1. Prerequisites

Make sure you have installed:

- Java JDK 21 or compatible version configured for the project
- MySQL Server
- MySQL Workbench (optional)
- Visual Studio Code or IntelliJ IDEA
- Git

### 2. Clone the Repository

```bash
git clone https://github.com/vrindharouli-beep/travel-planner.git
```

### 3. Open the Project

```bash
cd travel-planner
```

### 4. Create the MySQL Database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE travel_planner;
```

### 5. Configure Database Connection

Open:

`src/main/resources/application.properties`

Configure your MySQL connection:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/travel_planner
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.application.name=travel-planner
```

Replace `YOUR_MYSQL_PASSWORD` with your local MySQL password. Never upload real passwords or API keys to GitHub.

### 6. Run the Application

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

### 7. Open in Browser

Visit:

http://localhost:8080

You can now access Wanderly!

---

## 🏗️ Application Architecture

Wanderly follows a layered architecture:

- **Controller Layer:** Handles incoming HTTP requests and application navigation.
- **Service Layer:** Manages application business logic.
- **Repository Layer:** Communicates with the MySQL database through Spring Data JPA.
- **Entity Layer:** Defines the database model.
- **View Layer:** Uses Thymeleaf templates, HTML, and CSS to display application pages.

## 📸 Screenshots

Add screenshots of your actual application here to demonstrate its interface.

Suggested screenshots:

1. Home Page
<img width="1897" height="1020" alt="image" src="https://github.com/user-attachments/assets/d945ac20-bf0d-46ad-9955-0422a3270770" />
2. My Trips Dashboard
<img width="1877" height="1017" alt="image" src="https://github.com/user-attachments/assets/cc223016-26db-4477-a757-2688ed8d7f54" />
3. Plan a Trip Form
<img width="1355" height="1026" alt="image" src="https://github.com/user-attachments/assets/cfcb76d2-62e7-495b-b56c-f680a912e01d" />
4. Suggested destionations for tourists
<img width="1833" height="1042" alt="image" src="https://github.com/user-attachments/assets/f7854951-3763-4f01-8e03-16e45e0fa37d" />



Example:

```markdown
![Wanderly Home Page](screenshots/homepage.png)
```

## 🚀 Future Enhancements

- User authentication and authorization.
- Weather information through external APIs.
- Day-wise travel itinerary planning.
- Travel expense tracking and budget analytics.
- Interactive maps and destination exploration.
- Destination reviews and ratings.
- Trip sharing functionality.

## 🎯 Project Objectives

- Understand Spring Boot application development.
- Implement MVC architecture.
- Perform database operations using Spring Data JPA.
- Develop dynamic web pages using Thymeleaf.
- Understand the integration of frontend, backend, and database technologies.

## 👨‍💻 Developer

**Vrind Harouli**

B.Tech Computer Science and Engineering  
DIT University, Dehradun

- GitHub: [@vrindharouli-beep](https://github.com/vrindharouli-beep)

---

⭐ If you find this project interesting, consider giving it a star!

**Wanderly – Making Every Journey Easier.**
