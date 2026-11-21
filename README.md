# Spring Boot Database Security

This project shows how to access employee records securely using Java, Spring Boot, Spring Data JPA, Spring Security, and HTTPS. It uses an H2 database with three sample employees.

## What it demonstrates

1. **Spring Boot setup:** Maven project with the required dependencies.
2. **HTTPS and database access:** A PKCS12 KeyStore, an `Employee` entity, a JPA repository, and an employee controller.
3. **Spring Security:** Password-protected endpoints using HTTP Basic authentication over HTTPS. The password is hashed in memory with BCrypt.

Spring Data JPA safely binds the name search parameter instead of building SQL statements by joining input text.

## Run

Open the terminal in the project folder. 


```bash
bash run.sh
```

It enerates a local HTTPS KeyStore and prints a temporary username and password. 

The application runs at `https://localhost:8443/employees`.

### Test

1. Check that unauthenticated requests are blocked (HTTP 401):

   ```bash
   curl -ki https://localhost:8443/employees
   ```

2. View employee records. Enter the temporary password when prompted:

   ```bash
   curl -k -u student https://localhost:8443/employees
   ```

3. Search for an employee:

   ```bash
   curl -k -u student "https://localhost:8443/employees/search?name=Alex%20Morgan"
   ```

4. Check SQL injection text is treated as a search value
