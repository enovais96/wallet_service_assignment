# Project Wallet Service Assignment
Using Java, Spring Boot and MySQL, I created this project to perform simple operations on accounts, using three microservices:
1 - User.
2 - Wallet.
3 - Transaction.

# Programs Needed to Use This Project
	- Docker
	- Docker compose
    Note: All the tests are maded using Ubuntu 22.04.1

# How to Install and Run
	1 - Run the command docker network create recargapay.
  	2 - In the terminal, navigate to the user-service folder and run docker-compose up --build.
  	3 - In the terminal, navigate to the wallet-service folder and run docker-compose up --build.
  	4 - In the terminal, navigate to the transaction-service folder and run docker-compose up --build.
  	5 - Run the command docker start user-db.
  	6 - Run the command docker start wallet-db.
  	7 - Run the command docker start transaction-db.
  	8 - Run the command docker start user-service.
  	9 - Run the command docker start wallet-service.
  	10 - Run the command docker start transaction-service.
  	11 - Finally, execute the command docker ps to verify that you see 6 containers running, as shown below:
![image](https://github.com/user-attachments/assets/e65534cd-b3c8-415e-8e78-d481befa6a77)

	
# How to test
You can use this Postman collection, which includes a sequence of requests and example values: https://drive.google.com/file/d/1_xvs600rbsxKDeWcMWd2qCNCM-QOs11s/view?usp=sharing

# Project Documentation
Access the documentation here: https://docs.google.com/document/d/1sM0VrMkneBn5ez9Zzi1aKZ2BIHWywIloIl_EkAXqlBs/edit?usp=sharing
