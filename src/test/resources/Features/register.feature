Feature: User Registration
    Scenario: Successful registration with valid credentials
        Given I am on the registration page
        When I enter my email "darel@mail.com"
        And I enter my username "darrielrel"
        And I enter my password "123"
        And I confirm my password "123"
        And I submit the registration form
        Then I should see a success message "Register berhasil"

    Scenario: Password mismatch during registration
        Given I am on the registration page
        When I enter my email "darel@mail.com"
        And I enter my username "darrielrel"
        And I enter my password "123"
        And I confirm my password "456"
        And I submit the registration form
        Then I should see an error message "Password tidak sama"
