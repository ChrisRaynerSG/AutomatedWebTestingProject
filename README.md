# AutomatedWebTestingProject

This is a test automation framework for examining the functionality of [the Automation Excercise webpage](https://automationexercise.com/)

## User stories
To build a comprehensive test automation framework for examing the webpage, user stories were created in an initial planning session.

---

<img src="https://i.imgur.com/ncOP7yF.png" alt="project board">

---

These were then used to develop acceptance criteria using Gherkin Syntax, so that test cases could be developed.

---

<img src= "https://i.imgur.com/wj5G8Ij.png" alt="acceptance criteria">

---

## Project setup 

To setup this project the following dependencies are required for the test automation framework to function. These must be placed in the pom.xml of the project.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>com.sparta.cr</groupId>
    <artifactId>JavaTestUpskillingProject</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>2.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.13.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.13.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.23.1</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>2.0.7</version>
        </dependency>
    </dependencies>

</project>
```

## Tests
This test automation framework provides comprehensive end to end testing for the following features on the webpage:
  - registering a new user
  - logging in
  - deleting an account
  - searching the website
  - purchasing an item
  - leaving a review
  - subscribing to a mailing list
  - contacting support

This framework includes the ability to generate a cucumber to provide detailed information on test coverage, to run this report navigate to the TestRunner class 
```java
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json"},
        publish = true
)
public class TestRunner {

}
```
And run public class TestRunner

---

For any further enquiries please contact a member of the development team.



