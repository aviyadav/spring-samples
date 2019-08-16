# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### commands to test

curl http://localhost:8080
curl http://localhost:8080/books
curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Hamlet\",  \"author\" : \"William Shakespeare\",\"isbn\":\"978-0486272788\", \"published\":\"1937\",\"genre\":\"Novel\" }" http://localhost:8080/books
curl http://localhost:8080/books
curl http://localhost:8080/books/1

--- create multiple books
curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Hamlet\",  \"author\" : \"William Shakespeare\",\"isbn\":\"978-0486272788\", \"published\":\"1937\",\"genre\":\"Novel\" }" http://localhost:8080/books 

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"One Hundred Years of Solitude\",  \"author\" : \"Gabriel Garcia Marquez\",\"isbn\":\"978-0060883287\", \"published\":\"1967\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Love in the Time of Cholera\",  \"author\" : \"Gabriel Garcia Marquez\",\"isbn\":\"978-0307389732\", \"published\":\"1985\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Chronicle of a Death Foretold\",  \"author\" : \"Gabriel Garcia Marquez\",\"isbn\":\"978-1400034710\", \"published\":\"1981\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Of Love and Other Demons\",  \"author\" : \"Gabriel Garcia Marquez\",\"isbn\":\"978-1400034925\", \"published\":\"1967\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Memories of My Melancholy Whores\",  \"author\" : \"Gabriel Garcia Marquez\",\"isbn\":\"978-1400034925\", \"published\":\"2004\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Lolita\",  \"author\" : \"Vladimir Nabokov\",\"isbn\":\"978-0679723165\", \"published\":\"1989\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Don Quijote de la Mancha\",  \"author\" : \"Miguel de Cervantes\",\"isbn\":\"978-0307475411\", \"published\":\"2010\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Le Petit Prince\",  \"author\" : \"Antoine de Saint-Exupery\",\"isbn\":\"978-0156013987\", \"published\":\"2001\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"La Reine Margot\",  \"author\" : \"Alexandre Dumas\",\"isbn\":\"978-0199538447\", \"published\":\"2011\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"The hobbit\",  \"author\" : \" J. R. R. Tolkien\",\"isbn\":\"978-0345339683\", \"published\":\"1937\",\"genre\":\"Novel\" }" http://localhost:8080/books

curl http://localhost:8080/books/search/findByIsbn?isbn=978-0156013987
curl http://localhost:8080/books/search/getBooksByAuthor?author=Gabriel%20Garcia%20Marquez
curl http://localhost:8080/books/search/findByTitleContaining?title=Love
curl http://localhost:8080/books/search/countByAuthor?author=Gabriel%20Garcia%20Marquez
curl "http://localhost:8080/books/search/getBooksBetweenYears?startYear=2000&endYear=2015"

---replace
curl -i -X PUT -H "Content-Type:application/json" -d "{ \"title\" : \"The gift\", \"author\" : \"Vladimir Nabokov\",\"isbn\":\"978-0679725874\", \"published\":\"1992\",\"genre\":\"Novel\" }" http://localhost:8080/books/7
---Update a record: 
curl -i -X PATCH -i -H "Content-Type:application/json" -d "{ \"published\":\"1980\" }" http://localhost:8080/books/7
---Delete a record: 
curl -i -X DELETE -i http://localhost:8080/books/9
