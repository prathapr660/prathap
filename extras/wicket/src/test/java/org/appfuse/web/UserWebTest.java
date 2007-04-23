package org.appfuse.web;

import net.sourceforge.jwebunit.WebTestCase;

import java.util.ResourceBundle;

public class UserWebTest extends WebTestCase {
	private ResourceBundle messages;

    public UserWebTest(String name) {
        super(name);
        getTestContext().setBaseUrl("http://localhost:8080");
        getTestContext().setResourceBundleName("messages");
        messages = ResourceBundle.getBundle("messages");
        //getTestContext().setLocale(Locale.GERMAN);
        //getTestContext().getWebClient().setHeaderField("Accept-Language", "de");
    }

    public void testWelcomePage() {
        beginAt("/");
        assertTitleKeyMatches("index.title");
    }

    /*public void testAddUser() {
        beginAt("/userForm.html");
        assertTitleKeyMatches("userForm.title");
        setFormElement("firstName", "Spring");
        setFormElement("lastName", "User");
        submit("save");
        assertTextPresent("saved successfully");
    }

    public void testListUsers() {
        beginAt("/users.html");

        // check that table is present
        assertTablePresent("userList");

        // check that a set of strings are present somewhere in table
        assertTextInTable("userList", new String[] {"Spring", "User"});
    }

    public void testEditUser() {
        beginAt("/users,$DirectLink.sdirect?sp=l" + getInsertedUserId());
        assertFormElementEquals("firstName", "Spring");
        submit("save");
        assertTitleKeyMatches("userList.title");
    }*/

    /**
     * Convenience method to get the id of the inserted user
     * Assumes last inserted user is "Spring User"
     * @return last id in the table
     */
    /*public String getInsertedUserId() {
        beginAt("/users.html");
        assertTablePresent("userList");
        assertTextInTable("userList", "Spring");
        String[][] sparseTableCellValues =
                getDialog().getSparseTableBySummaryOrId("userList");
        return sparseTableCellValues[sparseTableCellValues.length-1][0];
    }*/

    protected void assertTitleKeyMatches(String title) {
        assertTitleEquals(messages.getString(title) + " | " + messages.getString("webapp.name"));
    }
}
