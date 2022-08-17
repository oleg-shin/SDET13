Feature: Employee search
  Scenario: Search employee by ID
    #Given user is navigated to HRMS application
    * user enters valid admin username and password
    * user clicks on login button
    * admin user is successfully logged in
    * user clicks on PIM option
    * user click on employee list option
    * user enters valid employee id
    * user clicks on search button
    * user is able to see the employee

  Scenario: Search employee by ID
    #Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user click on employee list option
    When user enters name of the employee
    And user clicks on search button
    Then user is able to see the employee
