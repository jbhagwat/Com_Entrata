# Selenium Automation Scripts for Entrata Site

## Overview

This repository contains Selenium automation scripts written in Java programming language to test the functionality of the demo site located at [https://www.entrata.com/].

## Prerequisites

Tools: Selenium WebDriver, GoogleChrome browser (Version 120), Maven, Github, TestNG, IntelliJ
programming language : Java.
Plugins: Create TestNG XML (to generate testng.xml file)

## Setup Instructions

Use link to clone the repository: 
Required dependancies are mentioned in the pom.xml file

## Running the Tests

You can execute tests using following maven command:
mvn clean verify -Dtest=ValidateFormFieldsOfWatchDemoIT
mvn clean verify -Dtest=ValidatePropertyManagementSectionLinksOfProductsTabIT
mvn clean verify -Dtest=VerifyAvailableResourcesOfResourcesTabIT
mvn clean verify -Dtest=VerifyListsOfFeaturesOfResidentPortalIT

## Test Cases
Please refer this document for the test cases in details: https://docs.google.com/spreadsheets/d/1vajtiDG_iRuYN4LFUnW7jUhIBztEdh_eVVr34Hu4z9w/edit?usp=sharing

## Reporting

Follow the steps to generate testNG emailbale report:
1) Generate your testng.xml file for the suite
2) Select your project in IntelliJ
3) Navigate to the Run menu and select Edit Configuration option
4) On Run/Debug Configuration pop-up window select the created testng.xml file
5) Click on Listeners tab
6) Click on plus (+) button and search for EmailableReporter & FailedReporter listeres and add them one by one
7) Apply and Ok
8) Now run the same testng.xml file to get the run report in test-output folder under project 

## Additional Notes

Use the same pom.xml file along with the versions to avoid configuration issues.
## Contact

emailId: jatureravi@gmail.com
