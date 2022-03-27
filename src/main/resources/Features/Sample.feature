@AppiumTest
Feature: Flipkart Login

  Scenario Outline: Flipkart Test with logins
    Given User initiates the appium driver
    When User provides the App Package "com.flipkart.android"
    And User provides the App Activity "com.flipkart.android.SplashActivity"
    Then User login with "<Username>" and "<Password>"
    Then User close the Application

    Examples:
      | Username                 | Password       |
      | krishnasai1907@gmail.com | 1907krishnasai |
