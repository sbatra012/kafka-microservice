# kafka-microservice
Event Driven Microservice

Flow:
Order Service places order Request to Kafka topic, Email Service and Stock Service Consumes the Request. Stock Service check if quantity is more than 5 or not and sends response to Order Service.


<img width="572" alt="image" src="https://user-images.githubusercontent.com/32607665/189689183-372b9d48-c0d3-44f9-afc0-3f4f624127f0.png">
