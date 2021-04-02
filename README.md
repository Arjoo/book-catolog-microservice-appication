Hi,

This application is developed by me(2009arjoo@gmail.com) and with purpose of learning microservices.

Agenda:
Find book catalog based on author,
where book-catalog is the combination of book-info and book-rating.

There are 3 microservices
- book-catalog microservice
- book-info microservice
- book-rating microservice


Implementation:
first book-catalog microservice interact with book-info microservice and try to capture
information based on bookauthor. Once it done, catalog try to interact with book-rating
microservice based on bookid. if we collect the data from both microservices then we need to prepare book-catalog by using the repsonse of both microservices.

Also added the changes for circuit breaker concept using netflix-hystrix in this implementation.


How to run:
Run all microservices application step wise as spring-boot-application
- start book-discovery-service
- start book-catalog-service
- start book-info-service
- start book-rating-service


- Goto any preferred browser
- Enter http://localhost:8761/ and see all microservices are registered here in discovery-server.
- Open new tab
- Enter http://localhost:8081/catalog/arjoo

here some predefined authorname are
- authorname : arjoo, anshul, ashish, shrawan etc.... use any name as authorname in above url.

Note:
I implemented this application only for learning purpose, that's why I preferred to use some dummy data.
In future, if there is any requirement of real time data, then I can add database changes at repository layer.
