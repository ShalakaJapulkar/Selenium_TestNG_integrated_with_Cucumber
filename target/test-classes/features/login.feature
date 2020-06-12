Feature: Login into Application
Scenario Outline: Entering credetials
Given Navigate to Landing Page "http://qaclickacademy.com"
And Click on Login link to navigate to sign in page
When User enters <username> and <password> and logs in
Then Login should be successful

Examples:
|username		 		|password	|
|test8229290@gmail.com	|1234567	|
|user01@gmail.com		|456789		|