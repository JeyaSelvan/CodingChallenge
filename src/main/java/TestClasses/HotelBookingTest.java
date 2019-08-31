package TestClasses;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HotelPage;
import Utilities.PageUtils;
import Utilities.Utilities;


public class HotelBookingTest {
	String url="appUrl";
	String browser = "chrome";

	@BeforeClass
	public void setEnv() {
		Utilities.setBrowser(browser, Utilities.getData(url));
	}
	@Test
	public void FlightBooking() throws IOException, InterruptedException{
		PageUtils.implicitWait(Utilities.getDriver(), 10);
		
		//Creating Object of Hotel Page and Soft Assert
		HotelPage hotel = new HotelPage(Utilities.getDriver());
		SoftAssert Assert = new SoftAssert();
		
		//Performing Actions on Hotel Page
		Assert.assertEquals(hotel.isTitleDisplayed(), true);
		hotel.ClickonHotelLink();
		hotel.setTexttoWhereTextBox(Utilities.getData("Where"));
		hotel.ClickonCheckInDate();
		hotel.ClickonCheckOutDate();
		hotel.SelectTravellersDropDown(Utilities.getData("Travellers"));
		hotel.ClickonSearchBtn();
		
		//Validation of the Search Header
		Assert.assertEquals(hotel.isSearchResultsHeaderDisplayed(), true);
		System.out.println(hotel.getSearchResultsHeader());
		String Actual = hotel.getSearchResultsHeader();
		
		//Final Validation
		Assert.assertTrue(Actual.contains("Bangalore (1 night)"));
		
		Assert.assertAll();
	}
	@AfterClass
	public void stop() {
		Utilities.tearDown();
	}

}
