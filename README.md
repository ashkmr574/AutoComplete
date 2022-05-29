# AutoComplete
This is a Spring-Boot Project that provides an auto-complete feature based on a list of words provided.

This exposes one REST API **/search** which is a POST request. you need to pass
the search string in request body as plain/text to get the result.

* It loads initial set of names from file **BoyNames.txt** present in src/main/resources/data folder into in-memory H2 database.
* These names are then read from database and loaded into Trie data structure which provides search feature in optimal way.
* Dockerfile is added, so you can run application in docker container.
* command to build the application : **mvn clean install**
* command to run in docker container : **docker run -p 9090:9090 ashkmr574/auto-complete**
