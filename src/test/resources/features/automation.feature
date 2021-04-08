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
Given User redirected to  url
When   User click on contact us button
Then   Contact us page is displayed


@searchProduct
Scenario: user is able to open application,search for the product
Given User redirected to  url
When User Search for product "Dress"
Then Search Result page is displayed

@facebook
Scenario: User is able to open application,click on facebook icon
Given User redirected to  url
When User click in facebook icon
Then facebook page is displayed

@twitter
Scenario: User is able to open application,click on twitter icon
Given User redirected to  url
When User click on twitter icon
Then twitter page is displayed

@youtube
Scenario: User is able to open application,click on youtube icon
Given User redirected to  url
When User click on youtube icon
Then youtube page is displayed

@googleplus
Scenario: User is able to open application,click on googleplus icon
Given User redirected to  url
When User click on googleplus icon
Then googleplus page is displayed

