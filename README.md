# myRetailRestfulService
Contains API to get, update and add new products, uses in memory database

Sample productIds : 	62736126,62736127,62736128

product Id is String

Test cases added for Controller.

Java Doc added for better understanding of code.

URL to make get request : http://localhost:8080/api/v1/product/62736126

URL to make put request : http://localhost:8080/api/v1/product/62736126

Body to update put request : {
        "price_value": 1000,
        "currency_code": "CND"
}

URL to make post request : http://localhost:8080/api/v1/product/
body : {"product_id":"627369799","product_name":"Jeans","product_price":{"price_value":"2000","currency_code":"INR"}}

This product is developed using Spring Boot Microservice.
