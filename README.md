Final Project: Automated QA Framework (UI & API)

Welcome to my Final Project Jayjay repository!

This project implements a unified Automation Testing framework combining Web UI and Rest API testing within a single repository. The framework is built upon best practices such as the Page Object Model (POM) and Gherkin format, and is fully automated using GitHub Actions for Continuous Integration (CI).

The project relies on the following tools and libraries for robust automation:

Programming Language: Java.
Build & Dependencies: Gradle.
Testing Framework: Cucumber.
Web UI Testing: Selenium WebDriver.
API Testing: Rest Assured.
CI/CD: GitHub Actions.
Version Control: Git & GitHub.

Testing Targets:
1. Web UI Test
Target    : DemoBlaze (https://www.demoblaze.com/)
Focus     : Testing the main user flow (selecting items, adding to cart, checkout, entering personal data).

2. API Test
Target    : DummyAPI.io (https://dummyapi.io/docs/user).
Operations: Implementation of CRUD operations (Get Users, Create User, Delete User, Update User).

How to Run Tests:
Run API Tests    : ./gradlew apiTest
Run Web UI Tests : ./gradlew webTest

Report Location:
HTML: build/reports/cucumber/html/index.html
