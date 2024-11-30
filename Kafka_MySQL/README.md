-> Start Zookeeper server using below command from Kafka folder

E:\kafka_2.13-3.8.0> bin\windows\zookeeper-server-start.bat config\zookeeper.properties


-> Start Kafka Server using below command from Kakfa folder

E:\kafka_2.13-3.8.0> bin\windows\kafka-server-start.bat config\server.properties

Create the SpringBoot Project with kafa dependency 

Implement the Kafka configuration and DB Configurations

Run the SpringBoot Project

POST: http://localhost:8080/api/users
{
    "name": "chiru",
    "email": "chiru@gmail.com"
}


To check the data in CLI :

E:\kafka\kafka_2.13-3.9.0\bin\windows>kafka-console-consumer.bat --topic user_topic --from-beginning --bootstrap-server localhost:9092

Database: 

CREATE DATABASE KafkaDB;
use KafkaDB;
show tables;
select * from user;
drop table user;