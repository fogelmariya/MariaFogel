Feature: JDI Home Page?

    Scenario: User Table Page test
      Given I'm on the Home Page
      When I login as user epam with password 1234
      And I open User Table Page through the header menu Service
      And I am on Users Table Page
      And User Table Page's interface contains correct elements
      When I check Number and User columns of Users table 
      Then User table contain correct values for numbers and users
      When I check Description column of Users table
      Then All cells of 'Description' column contains text
      When I set 'vip' status to Sergey Ivan
      Then 'Log' section shows a log row in format: FIELDNAME: condition changed to STATUS
      When I click on dropdown in column Type for user Roman
