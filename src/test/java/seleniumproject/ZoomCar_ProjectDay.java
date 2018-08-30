package seleniumproject;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ZoomCar_ProjectDay extends SeMethods {

	@Test
	public void CarBook() throws InterruptedException{


		startApp("chrome", "https://www.zoomcar.com/chennai ");
		locateElement("class", "search").click();
		locateElement("xpath", "//div[@class='items'][2]").click();
		locateElement("class", "proceed").click();
		locateElement("xpath", "//div[@class='month picked']").click();
		locateElement("xpath", "//div[@class='day'][1]").click();
		locateElement("class", "proceed").click();
		locateElement("class", "proceed").click();
		List<WebElement> carListing = driver.findElementsByClassName("car-listing");
		int size = carListing.size();

		List<WebElement> CarName = driver.findElementsByXPath("//div[@class= 'details']//h3");

		List <WebElement> CarRent = driver.findElementsByXPath("//div[@class= 'price']");

		Map<WebElement, Integer> priceComp = new HashMap<WebElement, Integer>();

		for (int i = 1; i <size; i++) {

			WebElement Car = CarName.get(i);
			String rent = CarRent.get(i).getText().replaceAll("\\D", "");
			Integer Rent = Integer.parseInt(rent);
			priceComp.put(Car, Rent);

		}

		int maxValueInMap=(Collections.max(priceComp.values()));
		for (Entry<WebElement, Integer> selection :priceComp.entrySet()) 

		{
			if(selection.getValue()== maxValueInMap) {
				WebElement action = selection.getKey();
				action.findElement(By.xpath("//button[@name='book-now']")).click();
			}
		}

		Thread.sleep(3000);

		closeAllBrowsers();




		/*for (Integer rent : priceComp.values()) {

		System.out.println(rent);

	}*/


		/*




		WebElement CarName = driver.findElementByXPath("//div[@class= 'details']//h3");
		String Modelname = CarName.getText();



		WebElement CarRent = driver.findElementByXPath("//div[@class= 'price']");
		String rent = CarRent.getText().replaceAll("\\D", "");
		Integer Rent = Integer.parseInt(rent);
		System.out.println(Rent);




		List<WebElement> ModelName = findElements(By.xpath("/div[@class= 'details']//h3"));

		for (WebElement Car : ModelName) {




		}*/





























	}

	private List<WebElement> findElements(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}
}
