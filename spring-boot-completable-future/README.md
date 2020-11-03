

Testing Application

- RUN mvn spring-boot:run

Postman

1. POST
URL - http://localhost:8080/api/car
Body
form-data
    key - files {type File}
    value - Cars.csv
Header
    Content-Type - multipart/form-data

2. GET
URL - http://localhost:8080/api/car
Body

Header
    Content-Type - application/json


