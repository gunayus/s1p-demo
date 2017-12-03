# Istanbul Spring Meetup - Spring Cloud Workshop Series #2 - demo project

## 1 - Build the project
mvn clean install

### 1.1 - Run weather-service stubs as a standalone server @port:8080
java -jar weather-service-stub-runner/target/weather-service-stub-runner-0.0.1-SNAPSHOT.jar --stubrunner.ids=org.springmeetup:weather-service:0.0.1-SNAPSHOT:8080 --server.port=8081

test the API stub 
curl http://localhost:8080/weather/current/TR/Ankara -i

### 1.2 - Open generated API docs:
open weather-service/target/generated-docs/index.pdf
open weather-service/target/generated-docs/index.html

## 2 - Run the weather-service micro service @port:8040

cd weather-service
mvn spring-boot:run

test the API : 
curl http://localhost:8040/weather/current/TR/Ankara -i


## 3 - Run the weather-web micro service @port:8050

cd weather-web
mvn spring-boot:run

Open the url http://localhost:8050 from your favourite browser

## 4 - References

https://www.youtube.com/watch?v=MDydAqL4mYE

https://github.com/spring-cloud/spring-cloud-contract

https://projects.spring.io/spring-restdocs/

