#Feature: User Login
#    Scenario: Login fails with incorrect username
#        Given I am on the login page
#        When I enter login username "wronguser"
#        And I enter login password "123"
#        And I submit the login form
#        Then I should see an error message "Username atau Password Salah!"
#
#    Scenario: Login fails with incorrect password
#        Given I am on the login page
#        When I enter login username "darrielrel"
#        And I enter login password "wrongpassword"
#        And I submit the login form
#        Then I should see an error message "Username atau Password Salah!"
#
#    Scenario: Login fails with empty username
#        Given I am on the login page
#        When I enter login username ""
#        And I enter login password "123"
#        And I submit the login form
#        Then I should see an error message "Username atau Password Salah!"
#
#    Scenario: Login fails with empty password
#        Given I am on the login page
#        When I enter login username "darrielrel"
#        And I enter login password ""
#        And I submit the login form
#        Then I should see an error message "Username atau Password Salah!"
#
#    Scenario: Successful login with valid credentials
#        Given I am on the login page
#        When I enter login username "darrielrel"
#        And I enter login password "123"
#        And I submit the login form
#        Then I should be redirected to the user dashboard
