# API Testing Framework

The following tecnologies were implemented in this project: 

- RestAssured
- Java
- TestNG
- Maven
- Page Object model as design pattern with POJO classes
- Jenkins integration

## Objective of this project

This project is a work automation plan that consists in attempting to create an API testing framework including above tecnologies.
The following web site is the one used for this plan: (which is a common web site for learning and assesment purposes.)

- https://reqres.in/

## Project Structure

The following is the basic structure of this project:
- resources > TestNG files
- test > base > tests
- target
- pom.xml

## TestNG files

- **GroupRun.xml:** this TestNG file will allow the tester to execute the test cases based on their groups, for example, some of the groups implemented are:

```sh
(groups = {"Regression", "Positive"})
(groups = {"Regression", "Negative"})
```
- **ParallelRun:** this TestNG file will allow the tester to execute the test cases in parallel way, which will improve the execution time of the test cases.
- **RegularRun:** this TestNG file will allow the tester to execute the test cases one by one.

## How to execute a test case(s)

1. **Via IDE running configuration (Edit Configuration option)**
- In order to use this way, the tester should set the following parameters previously:
```sh
VM Options: -Dbase_url=https://reqres.in/api -Dget_users_url=/users?page=2 (this is just an example)
```
2. **Via Maven command**
- In order to use this way, the tester should go to a terminal and export the following environment variables (if using MacOS):

```sh
export PASSWORD=brayan
```
- In the same terminal, in order to  start executing the test cases, the tester should run the following command:
```sh
mvn clean install -D TestNGFile=<TestNG file name>.xml
```

> Note: if using Windows, please refer to this documentation: https://www.architectryan.com/2018/08/31/how-to-change-environment-variables-on-windows-10/

## Where can this project be found?

This project can be found in the following link:
- https://github.com/brayanulloaGL/api_testing_java

**Happy testing!**
