BlogApplication is a full-stack web application built using Spring Boot (Backend) and JSP, HTML, CSS, Bootstrap, JavaScript (Frontend).
It allows users to create, edit, view, and delete blog posts with a clean and simple UI.

This project demonstrates core concepts of Spring MVC, JPA/Hibernate, REST API, and server-side rendering using JSP.

🚀 Features
✅ Add New Blog Post
Users can create blog posts by entering:
Title
Description
Username

✅ View All Posts
Homepage displays all posts in a responsive Bootstrap card layout.

✅ View Single Post
Each blog post can be opened individually for detailed reading.

✅ Edit Blog Post
Users can update title and description.

✅ Delete Blog Post
Posts can be removed safely with confirmation.

✅ Dedicated REST APIs
Backend exposes API endpoints for:
Creating posts
Fetching posts
Deleting posts
Getting posts by username

✅ Clean UI using Bootstrap
The frontend is built with:
HTML5
Bootstrap 5
Custom CSS
JavaScript for small interactivity

🧩 Tech Stack
Backend
Java 17
Spring Boot
Spring MVC
Spring Data JPA
Hibernate
MySQL

Frontend
JSP
HTML5
CSS3
Bootstrap 5
JavaScript

🗂️ Project Structure
src/main/java
  └── com.jsp.demo
        ├── controllers
        ├── entity
        ├── repository
        ├── serviceInterfaces
        ├── serviceImpl
        └── converters

src/main/webapp
  ├── WEB-INF/views (JSP pages)
  └── resources (CSS + JS)

🎯 Purpose of the Project
This project was created to practice and demonstrate:
Full-stack development using Spring Boot + JSP
MVC architecture
CRUD operations with JPA
Bootstrap UI development
Using Git & GitHub for version control
Real-world project structure for interviews
Perfect for students, beginners, and Java developers preparing for interviews.

📌 How to Run
1. Clone the project
git clone https://github.com/Priyanshu-Se/BlogApplication.git

2. Configure MySQL database
Create database:
CREATE DATABASE blogapplication;


Update application.properties:
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

3. Run the project
Open in Eclipse/STS → Run as → Spring Boot App

4. Access the UI
http://localhost:8080/posts

🎉 Conclusion
This BlogApplication is a complete beginner-friendly full-stack project showing backend REST APIs and a clean JSP-powered frontend. It is ideal for learning how a real-world Spring Boot MVC project works end-to-end.
