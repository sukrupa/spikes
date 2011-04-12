package org.sukrupa.schooladmin.steps;

import cuke4duke.annotation.I18n.EN.When;
import cuke4duke.annotation.I18n.EN.Given;
import org.sukrupa.schooladmin.On;
import org.sukrupa.schooladmin.pages.StudentSearchPage;

public class StudentSearchPageSteps extends BaseSteps {

    StudentSearchPage ssp;

    @Given("^I am on the Student Search page$")
    public void iAmOnTheSearchStudentsPage() {
        ssp = On.studentSearchPage();
    }

    @When("I add the talents \"([^\"]*)\"$")
    public void iAddtheTalents(String talents) {
        ssp=ssp.addTalents(talents);
    }


}
