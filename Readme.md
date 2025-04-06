# OCN Portal Automation Assignment

## Overview
This project automates **OCN Portal workflows** using **Selenium with Cucumber (BDD)**. The automation framework is structured using the **Page Object Model (POM)** for better maintainability, scalability, and modularization.

---

## 📁 Project Structure
```
Xalts_Automation_Assignment
├── .idea
├── allure-results
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Pages
│   │   │   │   ├── DashboardPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LaunchOCNChildNetworkPage.java
│   │   │   │   ├── OnboardingPage.java
│   │   │   │   ├── SigninPage.java
│   │   │   │   └── SignupPage.java
│   │   │   └── util
│   │   │       └── WebDriverFactory.java
│   └── test
│       ├── java
│       │   ├── Runner
│       │   │   └── TestRunner.java
│       │   ├── StepDefinition
│       │   │   └── SignupSigninSteps.java
│       └── resources
│           └── Feature
│               └── Xalts.feature
├── target
├── .gitignore
└── pom.xml
```

---

## 🧪 Technologies Used
- **Java 11+**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **Maven**
- **JUnit**
- **Allure Reports**
- **Page Object Model (POM)**

---

## ✅ Features Implemented
- **User Registration** automation
- **Authentication** with registered users
- **Node Onboarding** with wallet integration
- **Child Network Creation** for private blockchain setup
- **Dynamic Test Data** generation
- **BDD Feature Files** for human-readable test scenarios
- **Error Handling** with screenshot capture

---

## 🧾 Automated Test Cases

| Test ID  | Test Flow             | Test Case Description                              |
|----------|-----------------------|-----------------------------------------------------|
| ATC-001  | User Registration     | Sign up with new user credentials                  |
| ATC-002  | Authentication        | Sign in with registered credentials                |
| ATC-003  | Node Onboarding       | Submit request to onboard nodes with wallets       |
| ATC-004  | Child Network Creation| Submit request to create a new private blockchain  |

---

## 🔑 Key Framework Features
- 🔄 **Dynamic Data Generation**: Creates new email/password for every test run.
- 🧠 **State Management**: Static variables maintain user session across scenarios.
- 📸 **Error Handling**: Takes screenshots for failed tests.
- 🧩 **Page Object Model**: Keeps test logic separate from UI interaction logic.
- ✍️ **Readable BDD Syntax**: Tests written in Gherkin language.

---

## ▶️ Execution Steps

### Prerequisites
Ensure you have:
1. Java 11+
2. Maven
3. ChromeDriver or browser-specific WebDriver
4. IntelliJ IDEA / Eclipse
5. Git

### Run Tests
1. Clone the repository:
   ```bash
   git clone https://github.com/Beardo-cs/Xalts_Automation_Assignment
   ```

2. Navigate to the project directory:
   ```bash
   cd Xalts_Automation_Assignment
   ```

3. Execute tests via Maven:
   ```bash
   mvn clean test
   ```

4. Run with custom browser & options:
   ```bash
   mvn test -Dbrowser=chrome -Dheaded=true
   ```

5. View Allure Report:
   ```bash
   allure serve
   ```

6. View Cucumber HTML Report:
   ```bash
   open target/cucumber-reports/index.html
   ```

---

## 🔗 Resources

- 📽️ **Screen Recording**: [View Demo](https://docs.google.com/spreadsheets/d/1Qiv7xOBhHj_oBHAnStd6EaYRxzM0WWM3n_7Siyn5chA/edit#gid=1145001436)
- 📋 **Test Case Document**: [View Test Cases](https://docs.google.com/spreadsheets/d/1Qiv7xOBhHj_oBHAnStd6EaYRxzM0WWM3n_7Siyn5chA/edit#gid=1145001436h)

---

## 💻 GitHub Repository

You can access the source code here:  
🔗 [GitHub Repository – Xalts Automation Assignment](https://github.com/Beardo-cs/Xalts_Automation_Assignment)

