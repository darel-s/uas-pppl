Feature: User Registration
    Scenario: Successful registration with valid credentials
        Given I am on the registration page
        When I enter my email "darel@mail.com"
        And I enter my username "darrielrel"
        And I enter my password "123"
        And I confirm my password "123"
        And I submit the registration form
        Then I should be redirected to the login page

    Scenario: Password mismatch during registration
        Given I am on the registration page
        When I enter my email "darel@mail.com"
        And I enter my username "darrielrel"
        And I enter my password "123"
        And I confirm my password "456"
        And I submit the registration form
        Then I should see an error message "Password tidak sama"

    Scenario: Registration fails with already registered email
        Given I am on the registration page
        When I enter my email "darel@mail.com"
        And I enter my username "darrielrel"
        And I enter my password "123"
        And I confirm my password "123"
        And I submit the registration form
        Then I should see an error message "Register gagal"

    Scenario: Registration fails with all fields empty
        Given I am on the registration page
        When I enter my email ""
        And I enter my username ""
        And I enter my password ""
        And I confirm my password ""
        And I submit the registration form
        Then I should see an error message "Register gagal"