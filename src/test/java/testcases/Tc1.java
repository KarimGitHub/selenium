package testcases;

import org.junit.Test;

import wrapper.GenericWrappers;

public class Tc1 extends GenericWrappers {

	@Test
	public void createlead() {
		invokeApp("chrome", "http://demo1.opentaps.org");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");
		clickByLink("Create Lead");
		enterById("createLeadForm_companyName","Photon info TC1");
		enterById("createLeadForm_firstName","vishnupriyaTC1");
		enterById("createLeadForm_lastName","kTC1");
		selectVisibileTextById("createLeadForm_dataSourceId","Employee");
		selectIndexById("createLeadForm_marketingCampaignId","3");
		enterById("createLeadForm_primaryPhoneNumber","988445512");
		enterById("createLeadForm_primaryEmail","karim@gmail.com");
		clickByName("submitButton");
		String leadid = getTextById("viewLead_companyName_sp");	
		System.out.println(leadid);
		leadid = leadid.replaceAll("\\D", "");
		System.out.println(Integer.parseInt(leadid));
		quitBrowser();
	}

}
