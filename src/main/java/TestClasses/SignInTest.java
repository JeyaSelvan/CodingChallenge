package TestClasses;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.SignInPage;
import Utilities.PageUtils;
import Utilities.Utilities;

public class SignInTest {
	String url="appUrl";
	String browser = "chrome";

	@BeforeClass
	public void setEnv() {
		Utilities.setBrowser(browser, Utilities.getData(url));
	}
	@Test
	public void FlightBooking() throws IOException, InterruptedException{
		PageUtils.implicitWait(Utilities.getDriver(), 10);
		
		//Creating Object of Signin Page and Soft Assert
		SignInPage signin = new SignInPage(Utilities.getDriver());
		SoftAssert Assert = new SoftAssert();
		
		//Performing Actions on Signin Page
		signin.ClickonYourTrips();
		signin.ClickonSignInBtn();
		signin.ClickonPopupSignInBtn();
		System.out.println("The Error Msg is displayed as: "+signin.getErrorMsg());
		
		//Validations
		Assert.assertEquals(signin.isErrorMsgDisplayed(), true);
		Assert.assertEquals(signin.getErrorMsg(), "There were errors in your submission");
		
		Assert.assertAll();
	}
	@AfterClass
	public void stop() {
		Utilities.tearDown();
	}
}
