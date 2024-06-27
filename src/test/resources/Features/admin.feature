#Feature: Admin Login
#
#    Scenario: Successful login with valid credentials
#        Given I am on the login page
#        When I enter login username "adminlustrum"
#        And I enter login password "1234"
#        And I submit the login form
#        Then I should be redirected to the admin dashboard
#
#    Scenario: Admin views participant details
#        Given I am on the login page
#        When I enter login username "adminlustrum"
#        And I enter login password "1234"
#        And I submit the login form
#        Then I should be redirected to the admin dashboard
#        When I click on the participant details button
#        Then I should see the participant details page
#
#    Scenario: Admin approves participant
#        Given I am on the login page
#        When I enter login username "adminlustrum"
#        And I enter login password "1234"
#        And I submit the login form
#        Then I should be redirected to the admin dashboard
#        And I select to approve a participant
#        Then the participant should be approved
#
#    Scenario: Admin rejects participant
#        Given I am on the login page
#        When I enter login username "adminlustrum"
#        And I enter login password "1234"
#        And I submit the login form
#        Then I should be redirected to the admin dashboard
#        When I select to reject a participant
#        And I enter reject message
#        And I click confirm reject
#        Then the participant should be rejected
#
#    Scenario: Admin downloads all data
#        Given I am on the login page
#        When I enter login username "adminlustrum"
#        And I enter login password "1234"
#        And I submit the login form
#        Then I should be redirected to the admin dashboard
#        When I click on the download all data button
#        Then the data should be downloaded as a zip file
#
