Feature: Employee search
  Scenario: Search employee by ID
    Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user click on employee list option
    When user enters valid employee id
    And user clicks on search button
    Then user is able to see the employee
