Feature: Purchase the order from Ecommerce website

  Scenario Outline: Positive test of submit order
    Given Login with username <name> and password <password>
    When I add product <products> to the cart
    And checkout <products> and submit
    Then "Thankyou for the order." message is displayed

  Examples: 
    | name                  | password    | products      |
    | vvkrj@gmail.com  | Kratos@0607 | ZARA COAT 3   |
