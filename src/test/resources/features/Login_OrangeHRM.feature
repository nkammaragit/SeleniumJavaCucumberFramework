Feature: Login Functionality

@LoginTest
  Scenario: Successful login with valid credentials
    Given 	Launch Chrome browser
    When 		Open Orange HRM login page
    When    Enter valid username and password
    Then    Login success
    And 		Close the browser
   
   
   
   
   
   