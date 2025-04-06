Feature: User Registration, Login, and Node Setup in Xalts Portal

  Scenario: Sign up with new user credentials
    Given I launch the browser and navigate to Xalts home page
    When I click on Get Started
    And I enter email address
    And I enter password and confirm password
    And I click on Sign up button
    Then I click on Sign out button

  Scenario: Sign in with registered credentials
    Given I launch the browser and navigate to Xalts home page
    When I click on Get Started
    And I click on Sign In link
    And I enter the generated email and password
    And I click on Sign In button

  Scenario: Submit request to onboard nodes with wallets
    Given I launch the browser and navigate to Xalts home page
    When I click on Get Started
    And I click on Sign In link
    And I enter the generated email and password
    And I click on Sign In button
    Then Click on Get Started
    And Navigate to Onboard Node page
    And Add node with ID "NodeID-123" and IP "127.0.0.1"
    And Add node with ID "NodeID-456" and IP "192.168.1.2"
    And Click Next after adding nodes
    And Add wallet address "0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb"
    And Add wallet address "0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb"
    And Click Next after adding wallets
    And Submit the onboarding request



  Scenario: Submit Request To Create New Private Blockchain
    Given I launch the browser and navigate to Xalts home page
    When I click on Get Started
    And I click on Sign In link
    And I enter the generated email and password
    And I click on Sign In button
    Then Click on Get Started
    Then Click Launch OCN Child Network
    Then Enter the Network Name as "Test Network Name"
    Then Enter the Wallet address as "0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb"
    Then Click the Next button
    Then Enter Node ID as "NodeID-123"
    Then Enter Public IP as "127.0.0.1"
    Then Click Add Node button
    Then Click the final Next button
    Then Click the Submit button to create Blockchain
