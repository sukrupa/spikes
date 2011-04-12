package org.sukrupa.schooladmin.pages;

import net.sf.sahi.client.Browser;
import org.sukrupa.schooladmin.Page;

public class StudentSearchPage extends Page {

    public StudentSearchPage(Browser browser) {
        super(browser);
    }

    public StudentSearchPage addTalents(String talents) {
        String[] talentArray = talents.split(",");
        for (int i=0; i<talentArray.length; i++) {
            addTalent(talentArray[i].trim());
        }
        return this;
    }

    private void addTalent(String talent) {
        browser.select("availableTalents").choose(talent);
        browser.button("addTalent").click();
    }
}
