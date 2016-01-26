# allure-junit-parameterized
Read local file and test its content using junit 4.*. Reports in Allure. Building by maven.

# Requiremens
* Maven 3.3.9 or higher

# Preconditions
* dataFile.txt with the follwoing structure:
    - operand1;operand2;operation;result
    - operand1;operand2;operation;result
    - operand1;operand2;operation;result
    - operand1;operand2;operation;result
* operand1 and operand2 are Integer
* operation - arithmetical operation one of: + - / *
* result - operation result for operand1 and operand2

# What's done
* Junit test for math operation in dataFile.txt
* Report is generated in Allure
* Project is created as Maven artefact

# Usage
* $ mvn clean test
* $ mvn site
* To see a report, run mvn jetty:run and open http://localhost:8080 in your browser
