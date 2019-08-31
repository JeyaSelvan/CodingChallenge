package TestClasses;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.FlightPage;
import Utilities.PageUtils;
import Utilities.Utilities;

public class FlightBookingTest {
	String url="appUrl";
	String browser = "chrome";

	@BeforeClass
	public void setEnv() {
		Utilities.setBrowser(browser, Utilities.getData(url));
	}
	@Test
	public void FlightBooking() throws IOException, InterruptedException{
		PageUtils.implicitWait(Utilities.getDriver(), 10);
		
		//Creating Object of Flight Page and Soft Assert
		FlightPage flight = new FlightPage(Utilities.getDriver());
		SoftAssert Assert = new SoftAssert();
		Assert.assertEquals(flight.isTitleDisplayed(), true);
		
		//Performing Actions on Flight Page
		flight.ClickonOneWayRadioBtn();
		flight.setTexttoFromTextBox(Utilities.getData("From"));
		flight.setTexttoToTextBox(Utilities.getData("To"));
		flight.ClickonDepartDate();
		flight.ClickonDatePick();
		flight.ClickonSearchBtn();
		
		//Validation of the Search Header
		Assert.assertEquals(flight.isSearchResultsHeaderDisplayed(), true);
		System.out.println(flight.getSearchResultsHeader());
		String Actual = flight.getSearchResultsHeader();
		
		//Final Validation
		Assert.assertTrue(Actual.contains("Bangalore → New Delhi"));
		
		Assert.assertAll();
	}
	@AfterClass
	public void stop() {
		Utilities.tearDown();
	}

}
