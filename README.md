# Campus Lost & Found - Backend (In Development)

## 📖 Overview
The **Campus Lost and Found Portal** backend provides a centralized platform for students and staff to post and locate lost items within the campus community. This system ensures an **efficient, secure, and user-friendly** way to connect individuals who have lost items with those who have found them.

> ⚠️ **Note:** This project is currently under active development.

---

## ✨ Features

### 👤 Authentication & Role Management
- Secure registration and login for **Students** and **Admins**  
- JWT-based authentication for secure session management  
- Campus verification system (e.g., university email domains)

### 📦 Post Lost/Found Items
- Structured form to submit lost or found items  
- Fields include: `item name`, `description`, `category`, `date`, `location`  
- Support for **image uploads** for better identification

### 🔍 Auto-Matching & Search
- Intelligent algorithm to suggest potential matches between lost and found posts  
- Keyword similarity and location-based suggestions  
- Advanced search and filtering options

### 💬 Secure Chat System
- In-app messaging for private communication  
- Users can send/respond to contact requests to arrange item returns

### 🛡️ Admin Dashboard & Moderation
- Admin panel to manage content  
- Approve, edit, or delete user-submitted posts  
- Flag inappropriate content for review

### 📊 Reporting & Analytics
- Dashboard for admins to track:  
  - Number of items reported, matched, and recovered  
  - User engagement and platform activity

---

## 🛠️ Tech Stack
- **Language:** Java  
- **Framework:** Spring Boot  
- **Authentication:** Spring Security with JWT  
- **Database:** MySQL / PostgreSQL  
- **Image Storage:** Cloudinary  
- **API Documentation:** Swagger / OpenAPI

---

## 🚀 Getting Started

### Prerequisites
- JDK (Java Development Kit)  
- Maven / Gradle  
- MySQL or PostgreSQL  
- Cloudinary account for image storage

### Installation & Setup
```bash
# Clone the repository
git clone https://github.com/jitabhsin/CampusManagement-backend.git

# Navigate to the project directory
cd CampusManagement-backend

# Install dependencies
mvn install

# Configure application
# - Update database connection in application.properties
# - Add Cloudinary API credentials

# Run the application
mvn spring-boot:run
