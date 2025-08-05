# AWS EC2 & RDS Practice Project

A Spring Boot application demonstrating the integration between AWS EC2 (Elastic Compute Cloud) and RDS (Relational Database Service) for learning purposes.

## 🚀 Overview

This project is designed to practice and understand how to:
- Deploy a Spring Boot application on AWS EC2
- Connect to AWS RDS MySQL database
- Handle basic CRUD operations with JPA/Hibernate
- Manage cloud infrastructure

## 🛠️ Tech Stack

- **Backend**: Spring Boot 3.4.8
- **Database**: MySQL (AWS RDS)
- **ORM**: Spring Data JPA with Hibernate
- **Language**: Java 17
- **Build Tool**: Maven
- **Cloud**: AWS EC2 + RDS

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- AWS Account
- MySQL client (optional, for database management)

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/example/server/
│   │   ├── AppController.java      # REST API endpoints
│   │   ├── Board.java             # JPA Entity
│   │   ├── BoardRepository.java   # Data Access Layer
│   │   └── ServerApplication.java # Main application class
│   └── resources/
│       └── application.yml        # Configuration file
```

## ⚙️ Configuration

### Database Configuration

Update `src/main/resources/application.yml` with your AWS RDS credentials:

```yaml
spring:
  datasource:
    url: jdbc:mysql://YOUR_DATABASE_HOST:3306/YOUR_DATABASE_NAME
    username: YOUR_DATABASE_USERNAME
    password: YOUR_DATABASE_PASSWORD
    driver-class-name: com.mysql.cj.jdbc.Driver
```

## 🚀 Running the Application

### Local Development

1. Clone the repository:
```bash
git clone <repository-url>
cd server
```

2. Update the database configuration in `application.yml`

3. Run the application:
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:80`

### AWS EC2 Deployment

1. **Launch EC2 Instance**:
   - Choose Amazon Linux 2 or Ubuntu
   - Configure Security Groups (allow port 80)
   - Generate/Download key pair

2. **Connect to EC2**:
```bash
ssh -i your-key.pem ec2-user@your-ec2-public-ip
```

3. **Install Java and Maven**:
```bash
# Amazon Linux 2
sudo yum update -y
sudo yum install java-17-amazon-corretto -y
sudo yum install maven -y

# Ubuntu
sudo apt update
sudo apt install openjdk-17-jdk -y
sudo apt install maven -y
```

4. **Deploy Application**:
```bash
git clone <repository-url>
cd server
./mvnw clean package
java -jar target/server-0.0.1-SNAPSHOT.jar
```

## 📡 API Endpoints

- `GET /home` - Returns a simple welcome message
- `GET /boards` - Retrieves all boards and creates a sample board

## 🗄️ Database Schema

The application uses a simple `boards` table:

```sql
CREATE TABLE boards (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    content TEXT
);
```

## 🔧 AWS RDS Setup

1. **Create RDS Instance**:
   - Choose MySQL engine
   - Configure security groups to allow EC2 access
   - Note down endpoint, username, and password

2. **Security Group Configuration**:
   - Allow inbound traffic from EC2 security group on port 3306

## 🔒 Security Notes

- Never commit real database credentials to version control
- Use environment variables or AWS Secrets Manager for production
- Configure proper security groups for both EC2 and RDS
- Enable encryption at rest for RDS

## 📚 Learning Objectives

This project helps you understand:
- AWS EC2 instance management
- RDS database setup and connection
- Spring Boot deployment on cloud infrastructure
- Basic cloud security practices
- Database operations with JPA

## 🤝 Contributing

This is a learning project. Feel free to fork and experiment with different AWS services and configurations.

## 📄 License

This project is for educational purposes only.

## 🔗 Useful Links

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [AWS EC2 Documentation](https://docs.aws.amazon.com/ec2/)
- [AWS RDS Documentation](https://docs.aws.amazon.com/rds/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)