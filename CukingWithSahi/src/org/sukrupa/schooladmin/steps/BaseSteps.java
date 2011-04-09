package org.sukrupa.schooladmin.steps;

import org.sukrupa.schooladmin.Page;

import cuke4duke.annotation.After;

public class BaseSteps {
	@After("@logout")
	public void logMeOut() {
        Page.browser.link("Logout").click();		
	}	
}
