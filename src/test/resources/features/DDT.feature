Feature: Login Functionality2

@DDT
Scenario Outline: Successful login with valid credentials
  Given  Launch Chrome browser
  When   Open Orange HRM login page
  When   Enter username "<username>" and password "<password>"
  Then   Login success
  And    Close the browser

  Examples:
    | username | password  |
    | Admin    | admin123  |
    | User1    | pass1     |
    | User2    | pass2     |
    | User3    | pass3     |
    | User4    | pass4     |
