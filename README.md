# fancy-pdf

Basic web project with an embed tomcat. We use servlets and get information from request.

this project do:
- save users
- save invoices
- list all invoices
- return invoices in ```JSON``` format

Goal of this project:
- Understand servlets
- Configure ```pom.xml``` to create a executable jar
- Package configuration
- implements ```get``` and ```post```
- Get parameters of ```request```

to execute:
- open command line and go to the directory with a jar file
- execute ```java -jar fancy-pdf-1.0-SNAPSHOT.jar```
- test with ```http://localhost:8080/```

## endpoints
- create (POST): ```http://localhost:8080/invoices?user_id=Jesus&amount=30```
- list: ```http://localhost:8080/invoices```


