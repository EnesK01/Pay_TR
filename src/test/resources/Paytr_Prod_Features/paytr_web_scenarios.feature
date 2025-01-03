#This feature contains the scenarios of Paytr Production Website
@ApplyPageTests
Feature:  Paytr Production Website Cases


  Background: I open browser
    Given I open browser for and go to the Paytr production website loaded successfully for all scenarios
    Then Control of 12 subheadings of the Everything You Need for Payments heading
    Then Control of 5 subheadings of the Mainpage

@SuccessfullyReceivingThePaymentApplicationViaLink
  Scenario: Successfully receiving the limited company customer's payment application via the link and keeping the reference record
  Then I see product option and choose the payment type
  Then I check the payment via link page loaded successfully
  Then I take screenshot and save as "payment_via_link_page"
  Then I fill main first informations areas about company and choose businesstype
  Then I take screenshot and save as "first_areas_filled_from_Excel"
  Then I accept the terms and send apply
  Then I fill main second informations areas about company and choose businesstype
  Then I take screenshot and save as "second_areas_filled_from_Excel"
  Then I send apply for last time
  Then I see successfully apply and save the reference number
  Then I take screenshot and save as "successfully_applied"
