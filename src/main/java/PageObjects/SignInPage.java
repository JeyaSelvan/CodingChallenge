package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {
	
	//Locators

	@FindBy(xpath ="//h1[contains(text(),'Search flights')]")
	public WebElement Title;
	
	@FindBy(xpath ="//span[@class='span span19 truncate']")
	public WebElement YourTrips;
	
	@FindBy(xpath ="//input[@id='SignIn']")
	public WebElement SignInBtn;
	
	@FindBy(xpath ="//button[@id='signInButton']")
	public WebElement PopupSignInBtn;
	
	@FindBy(xpath ="//span[contains(text(),'There were errors in your submission')]")
	public WebElement ErrorMsg;
	
	
	//Constructor
	public SignInPage (WebDriver driver) {
	    PageFactory.initElements(driver, this);
	  }

	 
	 //User Methods
	 
	 public boolean isTitleDisplayed() {
		    return Title.isDisplayed();
	  }
	 public void ClickonYourTrips() {
		 YourTrips.click();
	  }
	 public void ClickonSignInBtn() {
		 SignInBtn.click();
	  }
	 public void ClickonPopupSignInBtn() {
		 PopupSignInBtn.click();
	  }
	 public String getErrorMsg() throws InterruptedException {
		  return ErrorMsg.getText();
	  }
	 public boolean isErrorMsgDisplayed() {
		    return ErrorMsg.isDisplayed();
	  }

}
