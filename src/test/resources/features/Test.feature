Feature: Test Feature

@DummyTest
  Scenario: TestScenario
    Given 	Open chrome browser
    When 		Open amazon url
    When    Provide valid username and password
    Then    Login should be success
    And 		Close amazon portal
    
    
    