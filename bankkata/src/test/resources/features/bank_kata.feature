Feature: Bank Account

  Scenario: Client deposits and withdraws money
    Given a client makes a deposit of 1000 on 29-01-2025
    And a client makes a deposit of 2000 on 29-01-2025
    And a client withdraws 500 on 29-01-2025
    When they print their bank statement
    Then they would see:
      | Date       | Amount | Balance |
      | 29/01/2025 | -500   | 2500    |
      | 29/01/2025 | 2000   | 3000    |
      | 29/01/2025 | 1000   | 1000    |
