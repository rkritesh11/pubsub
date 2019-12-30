****Running application in local****
1) Install maven if not installed
2) Download and install erlang 
    https://erlang.org/download/otp_win64_22.1.exe
3) Download and install rabbitmq
    https://dl.bintray.com/rabbitmq/all/rabbitmq-server/3.8.1/rabbitmq-server-3.8.1.exe
    
4) Enable rabbitmq management plugin 
    - As administrator open cmd and run rabbitmq-plugins enable rabbitmq_management
    - Within the rabbitmq_server-3.8.1\sbin directory are some scripts which run commands to control the RabbitMQ server.
      
      The RabbitMQ server can be run as either an application or service (not both).
      
      rabbitmq-server.bat starts the broker as an application
      rabbitmq-service.bat manages the service and starts the broker
      rabbitmqctl.bat manages a running broker
      
      OR
      
      In windows search you can search for RabbitMQ Service - start and start the rabbitmq
      
    - you can see the mangement console at http://localhost:15672/#/
    
5) Package the application and build the jar using maven 
    - mvn package
6) Run the JAR file in two terminal / cmd and pass to start the tomcat. This application can be started 
   as publisher and consumer using spring profiles
   - CONSUMER 1:- java -jar target/pubsub-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev,consumer --server.port=8080
   - CONSUMER 2:- java -jar target/pubsub-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev,consumer --server.port=8082
   - PUBLISHER:- java -jar target/pubsub-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev,publisher --server.port=8081
   
8) Using postman publish message to the URL 
       http://localhost:8081/sendNotification
       BODY:
       {
       	"message": "Hello world 1"
       } 
9) You can verify the message published is getting send to both the consumers as this is using fanout exchange.
