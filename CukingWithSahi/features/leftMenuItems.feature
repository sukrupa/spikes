Feature: Left Menu Items

	@logout
    Scenario: Verify Left Menu Items
    Given I am on the home page
    Then I should see side menu link of "Search Students"
    And I should see side menu link of "View All"
    And I should see side menu link of "View Events"
    And I should see side menu link of "Record Event"
    