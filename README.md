# Deva Project - Dark Fantasy API

### Description
Deva is a REST API for a dark fantasy game inspired by Dark Souls and Elden Ring. The main goal is to manage characters, their classes, attributes, and allow future expansions such as enemies, items, and skills.

### Technologies
- Java 17+
- Spring Boot (Web, Data, Security)
- Hibernate / JPA
- MySQL, MariaDB, H2
- Maven
- Swagger para documentação
- Lombok
- Git/GitHub


### Current Features
- Full CRUD for NPCs characters.
- Attributes based on classes (WARRIOR, MAGE, SAMURAI, DRUID, MONK, HEALER, PALADIN, ROGUE).
- CharacterClasses enum defines base attributes.
- Simple JSON character creation without the need for DTO.

### Future Implementations
- Unit and integration tests (JUnit and Mockito)
- SOLID principles and Hexagonal architecture
- Docker containerization
- Dev and Staging environments using DotEnv
- Integration with AWS and GCP
- Messaging with RabbitMQ
- Detailed error and exception handling

### Setup
1. Clone the repository
```bash
git clone https://github.com/renanp96/deva_project.git
cd deva_project
```
2. Configure the database in application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/deva_db
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```
3. Build and Run:
```bash
mvn clean install
mvn spring-boot:run
```
4. Access Swagger documentantion:
```
http://localhost:8080/swagger-ui.html
```

### Example JSON to Create a Character
```
{
  "name": "Akreth",
  "characterClass": "SAMURAI"
}
```