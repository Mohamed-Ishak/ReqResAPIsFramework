# ReqRes => Automation Framework

# Dependencies
✅ RestAssured for API testing
✅ TestNG for test execution
✅ Maven for dependency Manager

📌 Project Structure

📂 src/test/java (Test Code)

📁 steps/ → 
  - BaseTest class for setup and reusable functions 
  - CRUD operations class for create Tests.
📁 utils/ → 
  - Includes ConfigManager to manage configurations centrally.
  - JsonUtils class to read json files
 📂 src/test/resources (Test Data & Config.properties to store the URL and other configurations)


🔹 Prerequisites

Java 8+ installed   
Maven installed (mvn -version to check)     

Clone this repository: git clone (https://github.com/Mohamed-Ishak/SimpleBooksAPIs.git)

🔹 Run Tests using Maven command via terminal using **mvn test**   

 Notes:  
The API is a mock so when you create a new user and try to get it
this will not work and 404 stats code will display because the user is not added in the database 










