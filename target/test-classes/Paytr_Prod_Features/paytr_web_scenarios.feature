#This feature contains the scenarios of Paytr Production Website
@ApplyPageTests
Feature:  Paytr Production Website Cases


  Background: I open browser
    Given I open browser for and go to the Paytr production website for all scenarios


@ApplyPageSmoketest
    Scenario: A non-customer must be able to go to the apply page via the home page.
            Then Non-customer click the apply button
            Then Non-customer see the apply page
            Then I take screenshot and save as "apply_page_control"

  @ApplyPageNegativetest
  Scenario: if a non-customer leaves any of the fields blank they should see the error message
    Then Non-customer click the apply button
    Then Non-customer see the apply page
    Then Non-customer fills name, surname,phone,gmail areas
    Then Non-customer chooses the business type and left the other areas empty
    Then Non-customer accept the terms and apply
    Then Non-customer should see missing area warnings
    Then I take screenshot and save as "check_not_printing_with_missing_fields"