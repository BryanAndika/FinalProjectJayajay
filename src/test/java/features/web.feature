Feature: Test automation web

  @web
  Scenario: Test purchasing Phone
    Given open web demoblaze
    And user go to phone section
    And user select phone
    And add phone to cart
    And user go to cart page
    Then verify total price is "360"
    And user place order from cart
    And user input data:
      | field   | value              |
      | name    | Bryan              |
      | country | Indonesia          |
      | city    | Jakarta            |
      | card    | 1234 5678 9999 0000|
      | month   | 12                 |
      | year    | 2025               |
    And user click purchase
    And user will see successful message "Thank you for your purchase!"

  @web
  Scenario: Test purchasing Laptop
    Given open web demoblaze
    And user go to laptop section
    And user select laptop
    And add laptop to cart
    And user go to cart page
    Then verify total price is "790"
    And user place order from cart
    And user input data:
      | field   | value              |
      | name    | Andika             |
      | country | Indonesia          |
      | city    | Jakarta            |
      | card    | 1523 1245 1846 6548|
      | month   | 9                  |
      | year    | 2025               |
    And user click purchase
    And user will see successful message "Thank you for your purchase!"

  @web
  Scenario: Test purchasing monitor
    Given open web demoblaze
    And user go to monitor section
    And user select monitor
    And add monitor to cart
    And user go to cart page
    Then verify total price is "400"
    And user place order from cart
    And user input data:
      | field   | value              |
      | name    | Saputra            |
      | country | Indonesia          |
      | city    | Bali               |
      | card    | 9875 5468 1846 6548|
      | month   | 2                  |
      | year    | 2025               |
    And user click purchase
    And user will see successful message "Thank you for your purchase!"