#Zomato API Automation
Project Title
Zomato -API Automation.

Prerequisites
IMPORTANT : JDK should be there in path rather than JRE to avoide "No compiler is provided in this environment" error.

Maven must be installed and its MAVEN_HOME should be configured.
Internet Connection must be stable and high speed.
There should not be restrictions (access denied) to download dependencies from pom.xml
It will be good if eclipse/other ide is installed and imported this project.
Design Adopted
i) Design of framework is Modularised. ii) Each Test API has its own class. iii) Clear separation between test cases and Action classes.

Project Structure
A) Under src/main/java:

There are different Action classes made in src/main/java/actions/UserActions.java

B) Under src/test/java:

There are different 2 test classes made in src/test/java/api_test

i) GetUsersByPhoneTest ii) UsersTests

C) I have designed this framework so that all the Properties are at on place UrlProperties. One may change the data under src/main/resources/Url.properties 
D) All the resources of the project are under RestUrlMapper src/main/java/urls/RestUrlMapper.java 
E) All utitily classes are under src/main/java/utils 
F) Base class and Authentication class are under src/main/java/common 
G) There is one pom.xml in which all dependencies are set.

Instructions#####
User can change the Base url and user credentials from properties file under src/main/resources/Url.properties.
User can add the resources project are under RestUrlMapper src/main/java/urls/RestUrlMapper.java
TEST BED
jdk:8 and above
rest-assured version:  2.9.0
TestNG version: 6.14.3
Run the project
Open the project in Intellj or other IDE.
Right click any of the test class and run.
