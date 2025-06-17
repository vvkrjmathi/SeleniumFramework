
Feature: Login error validation

  Scenario Outline: Login with invalid credentials and verify error message
    Given I landed on Ecommerce page
    When Login with username <name> and password <password>
    Then "<errorMsg>" message is displayed
    And Product verfication <products>
    
  
 
Examples: 
    | name                  | password    | products      |
    | vvkrj@gmail.com  | Kratos@607 | ZARA COAT 3   |

