@ui @automation
@tag
Feature: Automation testing Web Site  Check


@signin
    Scenario: User is able to Open the browser, navigate to the URL and click on sign in button
    Given User redirected to  url
    When User click on sign in button
    Then Sign in page is displayed

    
@contactus
Scenario: user is able to open website,click on contact us option
Given User opened url
When   User click on contact us button
Then   Contact us page is displayed