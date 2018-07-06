Feature: JDI Home Page?

  Scenario: Home Page Interface test
    Given I'm on the Home Page
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user icon  is displayed on the header and have name PITER CHAILOVSKII
    And In the page are 4 images and they have text under them and there are 2 main text
    And Service dropdown on the top menu has 8 items with necessary texts SUPPORT, DATES, COMPLEX TABLE, SIMPLE TABLE, USER TABLE, TABLE WITH PAGES, DIFFERENT ELEMENTS, PERFORMANCE
    And Service dropdown on the left menu has 8 items with necessary texts SUPPORT, DATES, COMPLEX TABLE, SIMPLE TABLE, USER TABLE, TABLE WITH PAGES, DIFFERENT ELEMENTS, PERFORMANCE
    When I open Different Element page by Service dropdown on the top menu
    Then The browser title is Different Element
    And On the page are 4 checkboxes, 4 radios, 1 dropdown, 2 buttons
    And there is Left Section
    And there is Right Section
    When I select checkboxes Water
    And I select checkboxes Wind
    Then Log contains row Water has condition true
    And Log contains row Wind has condition true
    When I select radio Selen
    Then Log contains row metal has value Selen
    When I select in dropdown Yellow
    Then Log contains row Colors has value Yellow
    When I unselect and assert checkboxes Water
    And I unselect and assert checkboxes Wind
    Then Log contains row Water has condition false
    And Log contains row Wind has condition false

