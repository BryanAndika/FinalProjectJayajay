Final Project: Automated QA Framework (UI & API)

Welcome to my Final Project Jayjay repository!

This project implements a unified Automation Testing framework combining Web UI and Rest API testing within a single repository. The framework is built upon best practices such as the Page Object Model (POM) and Gherkin format, and is fully automated using GitHub Actions for Continuous Integration (CI).

The project relies on the following tools and libraries for robust automation:

Programming Language: Java (Primary language for framework development)
Build & Dependencies: Gradle (Project and dependency management)
Testing Framework: Cucumber (Gherkin) (Used for Behavior-Driven Development (BDD) test case format)
Web UI Testing: Selenium WebDriver (Automation of Web UI element interaction)
API Testing: Rest Assured (Testing and validation of RESTful API services)
CI/CD: GitHub Actions (Automation of test execution on specified events)
Version Control: Git & GitHub (Source code management and collaboration)

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
