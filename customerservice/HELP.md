# Getting Started

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)


commands:

curl -s -G http://localhost:8088/restapi/customers | json_pp
curl -s -G http://localhost:8088/restapi/customers?sort=customerId,desc
curl -s -G http://localhost:8088/restapi/customers/1/accounts
curl -s -H "Content-Type: application/json;accept: application/json" -X POST -d '{"customerName": "Iris Zhang","dateofBirth": "1985-03-16","phoneNumber": "+610452623738"}' http://localhost:8088/restapi/customers/
curl -s -H "Content-Type: application/json;accept: application/json" -X POST -d '{"accountNumber": 30981069,"accountName": "gold plus","balance": 12000,"openingDate": "2016-05-16"}' http://localhost:8088/restapi/customers/3/accounts
curl -s -H "Content-Type: application/json;accept: application/json" -X PUT -d '{"customerName": "Iris Wong","dateofBirth": "1985-03-16","phoneNumber": "+610452623738"}' http://localhost:8088/restapi/customers/3 
curl -s -H "Content-Type: application/json;accept: application/json" -X PUT -d '{"accountNumber": 30981069,"accountName": "silver plus","balance": 12000,"openingDate": "2016-05-16"}' http://localhost:8088/restapi/customers/3/accounts/30981069 

curl -s -i -H "Content-Type: application/json;accept: application/json" -X DELETE  http://localhost:8088/restapi/customers/3/