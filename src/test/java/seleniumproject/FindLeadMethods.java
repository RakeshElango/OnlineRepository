package seleniumproject;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FindLeadMethods extends SeMethods {

	@Test
	public void login() throws InterruptedException {
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "crmsfa");
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement locateElement1 = locateElement("partialtext", "CRM/SFA");
		click(locateElement1);
		locateElement("linktext", "Leads").click();
		WebElement findLeads = locateElement("linktext", "Find Leads");
		click(findLeads);
		WebElement fname1 = locateElement("xpath", "(//div[@class='x-tab-panel-body x-tab-panel-body-top']//input)[2]");
		type(fname1, "Gopinath");
		WebElement findbut = locateElement("xpath", "//div[@class='x-panel-footer x-panel-footer-noborder']//button");
		click(findbut);
		WebElement cell = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]");
		click(cell);
		verifyTitle("View Lead");
		WebElement edit = locateElement("xpath", "//a[@class='subMenuButton'][3]");
		click(edit);
		WebElement companyName = locateElement("updateLeadForm_companyName");
		companyName.clear();
		type(companyName, "Cognizant");
		WebElement update = locateElement("xpath", "//input[@name='submitButton'][1]");
		click(update);
		//WebElement verify = locateElement("Cognizant");
		//verifyDisplayed(verify);
		
		driver.quit();





	}
}
