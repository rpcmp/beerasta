## Requirements

**Java 8**

[**Node 10.16.3**](https://nodejs.org/dist/v10.16.3/)

**npm 6.9.0**

[**Maven**](https://maven.apache.org/)

**PostgreSQL 9.6+**

## Build and run jar

Create database `beerasta` on you local PostgreSQL DB with login\password: `postgres` and 5432 port

In the project directory

    mvn clean package

In `target` folder
    
    java -jar beerasta-1.0-SNAPSHOT.jar
    
Open [http://localhost:8080](http://localhost:8080) and check the app
    
#### Next you can run react front with hot deploy

In `src/RPC`

    npm install
    
    npm start
    
Now you can debug front on [http://localhost:3000](http://localhost:3000) with hot deploy 