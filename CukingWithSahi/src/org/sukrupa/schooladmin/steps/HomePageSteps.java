package org.sukrupa.schooladmin.steps;

import org.sukrupa.schooladmin.On;
import org.sukrupa.schooladmin.pages.HomePage;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;

import static org.junit.Assert.assertEquals;;

public class HomePageSteps extends BaseSteps {
	
	private HomePage hp;

	@Given("^I am on the home page$")
	public void iAmOnTheHomePage() {
		hp = On.homePage();	
	}
	
	@Then("^I should see side menu link of \"([^\"]+)\"$")
	public void iShouldSeeLink(String menuText) {
		assertEquals(true, hp.isSideMenuItemVisible(menuText));
	}
}
