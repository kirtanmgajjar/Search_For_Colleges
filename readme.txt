Case Study: Search For Colleges

Problem Statement:
Find college details in Eduvidya application.

Suggested site: https://www.eduvidya.com/


Detailed Description:

-Open the browser
-Enter the URL https://www.eduvidya.com/
-Click on "Colleges" link in the Menu bar
-Click on "Course" dropdown and select a course (ex: Science)
-Click on "City" dropdown and select “Chennai” as city
-Click on "Search" button
-Verify Search results is displayed or not
-Close the browser


Key Automation Scope:

-Handling multiple browsers Chrome/Firefox
-Handling Text boxes
-Locating elements precisely
-Exception handling
-Handling dropdown list


About the implementation of the project:

-"com.eduvidya.Automaton.baseClass" package is created with two classes "DriverSetup" and "BaseClass" inside "src/main/java" folder.
-"DriverSetup" contains methods to create driver for the web browswers for Chrome, Edge and Firefox.
-"BaseClass" contains the methods to run before start and after end of the test.
-"com.eduvidya.Automaton.automationTest" package is created with class "AutomationTest" inside "src/test/java" folder.
-"AutomationTest" is a TestNG class whic extends the BaseClass and  which carries out the test automation required and can be run using the "testng.xml" located in the main folder.
-Before running the test, user is prompted in the console to choose the browser for running the test.


Created By:

Name - Kirtan Gajjar
Associate Id - 2234444
