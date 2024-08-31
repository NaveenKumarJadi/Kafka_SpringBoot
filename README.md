# Kafka_SpringBoot

Kafka Installation:
Download and run Zookeeper
Download and run Apache Kafka server
Create Topic in Apache Kafka

Open Source: Apache Kafka
Commercial distribution: Confluent Kafka
Managed Kafka Service: confluent & AWS

Download and Use offsetExplorer:  https://www.kafkatool.com/download.html

========================================
Spring Boot + Apache Kafka Application
=======================================
Step-1 : Download Zookeeper from below URL
   URL : http://mirrors.estointernet.in/apache/zookeeper/stable/
Step-2 : Download Apache Kafka from below URL
   URL : http://mirrors.estointernet.in/apache/kafka/
Step-3 : Set Path to ZOOKEEPER in Environment variables upto bin folder
Step-4 : Start Zookeeper server using below command from Kafka folder
Command : zookeeper-server-start.bat zookeeper.properties

E:\kafka_2.13-3.8.0> bin\windows\zookeeper-server-start.bat config\zookeeper.properties

Note: Above command will available in kafka/bin/windows folder

Note: zookeeper.properties file will be available in kafka/config folder. You can copy zookeeper.properties and server.properties files from kafka/config folder to kafka/bin/windows folder.
Step-5: Start Kafka Server using below command from Kakfa folder
Command : kafka-server-start.bat server.properties
E:\kafka_2.13-3.8.0> bin\windows\kafka-server-start.bat config\server.properties

Note: server.properties file will be available in config folder (Copied to windows folder)

Step-6 : Create Kakfa Topic using below command from kafka/bin/windows folder
Command : kafka-topics.bat --create --bootstap-server localhost:9092 --replication-factor 1 --partitions 1 --topic demo-jrtp22-topic

E:\kafka_2.13-3.8.0> bin\windows\kafka-topics.bat --create --topic Ramayana --bootstrap-server localhost:9093 --replication-factor 1 --partitions 1
Created topic Ramayana.

Step-7 : View created Topics using below command
Command : 
E:\kafka_2.13-3.8.0> bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9093

Topic Delete Command:
E:\kafka_2.13-3.8.0> bin\windows\kafka-topics.sh --bootstrap-server localhost:9093 --delete --topic my-topic-name

Step-8 : To Describe the created Topic
E:\kafka_2.13-3.8.0>bin\windows\kafka-topics.bat --describe --bootstrap-server localhost:9093 --topic hanuman

Step-9 : Post Message into Kafka topic:
E:\kafka_2.13-3.8.0> bin\windows\kafka-console- producer.bat --topic Ramayana --from-beginning --bootstrap-server localhost:9093

E:\kafka_2.13-3.8.0> bin\windows\kafka-console- producer.bat --topic Ramayana --bootstrap-server localhost:9093

Step-10 : Consume Message into Kafka topic:
E:\kafka_2.13-3.8.0>bin\windows\kafka-console-consumer.bat --topic Ramayana --from-beginning --bootstrap-server localhost:9093

While creating we have to face some exception: 
=>  Verify Kafka Version:
Run kafka-topics.bat --version and compare it to the version running on your Kafka broker

=> Add this line in server.properties: (if required change the port number)
listeners=PLAINTEXT://localhost:9092
=> Check the Kafka broker logs (typically in logs/kafkaServer.out or similar) for any errors or warnings.

=> Run a command like kafka-console-producer.sh --broker-list localhost:9092 --topic test to see if the broker responds properly.


============================================
Step-11 : Create Spring Boot Project in IDE
============================================

Step-9: Add below kafka related dependencies in pom.xml

		<dependency>
			<groupId>org.apache.kafka</groupId>
			<artifactId>kafka-streams</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.kafka</groupId>
			<artifactId>spring-kafka</artifactId>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
		</dependency>
		
Step-12: Create RestController, KafaProducer and KafaConsumer classes to publish and subsribe message

Step-13: Test application using PostMan.     

POST: http://localhost:9090/addCustomer

Request Data:
[
	{
		"customerId": 1010,
		"customerName": "Ram",
		"customerEmail": "ram@gmail.com"
	},
	{
		"customerId": 1011,
		"customerName": "shiva",
		"customerEmail": "shiva@gmail.com"
	},
	{
		"customerId": 1012,
		"customerName": "stalin",
		"customerEmail": "stalin@gmail.com"
	}
]
