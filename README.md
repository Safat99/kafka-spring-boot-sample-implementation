# Kafka-spring-boot-test-service-implementation

This is a spring boot project where a imaginary service named as email-service is done.

## To start the project
Steps
* check the cli_commands.md
* Start the kafka server (using Kraft is recommended)
* Run the app
* hit with postman the following 2 APIs that I have created and check the results.

## Outputs

1. Sending string from the payload to kafka<br><br>
![postman-string](outputs/postman_send_string.png)
<br><br>Now Kafka in kafka the message(string) will be look like this:<br><br>
![kafka-console-string](outputs/string_in_kafka.png)


2. Sending object from the payload to kafka<br><br>
![postman-object](outputs/postman_send_object.png)
<br><br>
Now Kafka in kafka the message(object) will be look like this:<br><br>
![kafka-console-dto](outputs/objects_in_kafka.png)
