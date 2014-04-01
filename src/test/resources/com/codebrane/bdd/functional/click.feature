@Click
Feature: Test Click

Scenario: Testing the click functionality
  Given I navigate to the test application
  When I click on the link
  Then I should see an expression test page