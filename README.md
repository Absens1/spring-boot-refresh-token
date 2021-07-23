# spring-boot-refresh-token
Пример обновления JWT при помощи refresh token.


## APIs:
| Methods | Urls | Actions |
|:--------|:-----|:--------|
| POST | /api/auth/signup | signup new account |
| POST | /api/auth/signin | login an account |
| POST | /api/auth/refreshtoken | refresh access token |
| GET | /api/test/all | retrieve public content |
| GET | /api/test/user | access User’s content |
| GET | /api/test/mod | access Moderator’s content |
| GET | /api/test/admin | access Admin’s content |


## Preview
- **Send /signup request, return response message.**
<img src="https://c.radikal.ru/c38/2107/95/e47636f2b940.png" width="800" />  

- **Send /signin request, return response with refreshToken.**
<img src="https://c.radikal.ru/c15/2107/49/19033092d620.png" width="800" /> 

- **Send /refreshtoken request, return response with new access and refresh token.**
<img src="https://c.radikal.ru/c15/2107/a5/9d8bd567fb73.png" width="800" />


## Run Spring Boot application
```
mvn spring-boot:run
```


## Test data
```
username: user
password: 100

username: moder
password: 100

username: admin
password: 100
```


## Dependency
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
  <groupId>org.flywaydb</groupId>
  <artifactId>flyway-core</artifactId>
</dependency>

<dependency>
  <groupId>javax.validation</groupId>
  <artifactId>validation-api</artifactId>
  <version>2.0.1.Final</version>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt</artifactId>
  <version>0.9.1</version>
</dependency>
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>org.springframework.security</groupId>
  <artifactId>spring-security-test</artifactId>
  <scope>test</scope>
</dependency>
```


## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.yaml`
```yaml
server:
  port: 8189
spring:
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:mydatabase;MODE=PostgreSQL
    username: sa
    password:
  jpa:
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.H2Dialect
  h2:
    console:
      enabled: true
      settings:
        web-allow-others: false
```
Open `src/main/resources/app.properties`
```properties
jwt.secret=93hf2938hf948hf948hf984ht89h439th849rh849rh439r8h4389h4fn94f
jwt.expirationMs=3600000
jwt.refreshExpirationMs= 86400000
```
