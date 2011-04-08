Feature: Login

    Scenario: Logout after login
    Given I am logged in
    When I click on the "Logout" link
    Then I should be logged out

    Scenario: Login with valid credentials
    Given I am on the login page
    When I log in using "admin" and "password"
    Then I should be logged in

    Scenario: Login with invalid credentials - wrong username
    Given I am on the login page
    When I log in using "wrongadmin" and "password"
    Then I should receive an error "Invalid username and password"

    Scenario: Login with invalid credentials (wrong password)
    Given I am on the login page
    When I log in using "admin" and "wrongpassword"
    Then I should receive an error "Invalid username and password"
