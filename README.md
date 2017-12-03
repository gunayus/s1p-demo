# SpringOne platform 2017 - demo project

## 1 - Build the project

```shell
egunay$ git clone https://github.com/gunayus/s1p-demo.git
egunay$ cd s1p-demo
s1p-demo egunay$ mvn clean install
```

### 1.1 check API docs are generated
```shell
s1p-demo egunay$ ls -al weather-service/target/generated-docs/
total 184
drwxr-xr-x   4 egunay  staff    136 Dec  3 11:07 .
drwxr-xr-x  15 egunay  staff    510 Dec  3 11:07 ..
-rw-r--r--   1 egunay  staff  35407 Dec  3 11:07 index.html
-rw-r--r--   1 egunay  staff  56901 Dec  3 11:07 index.pdf
```


### 1.1 - Run weather-service stubs as a standalone server @port:8080
```shell
java -jar weather-service-stub-runner/target/weather-service-stub-runner-0.0.1-SNAPSHOT.jar --stubrunner.ids=org.springmeetup:weather-service:0.0.1-SNAPSHOT:8080 --server.port=8081
```

test the API stub 

```shell
egunay$ curl 'http://localhost:8081/stubs' -i
HTTP/1.1 200 
X-Application-Context: application:8081
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Sun, 03 Dec 2017 19:41:35 GMT
```

```json
{
	"org.springmeetup:weather-service:0.0.1-SNAPSHOT:stubs":8080
}
```

```shell
egunay$ curl 'http://localhost:8080/weather/current/TR/Denizli' -i
HTTP/1.1 200 OK
Content-Type: application/json
Transfer-Encoding: chunked
Server: Jetty(9.4.7.v20170914)
```

```json
{
	"temperature": 39.15,
	"weatherId": 800,
	"weatherIcon": "01d",
	"name": "Denizli",
	"timestamp": 1505824065
}
```

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

