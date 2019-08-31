package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtils;
import Utilities.Utilities;


public class HotelPage  {
	
	//Locators

	@FindBy(xpath ="//h1[contains(text(),'Search for hotels')]")
	public WebElement Title;
	
	@FindBy(xpath ="//ul[@class='navGroup productNav withArrows']//li[contains(@class,'hotelApp')]/a[@href='/hotels']")
	public WebElement HotelLink;
	
	@FindBy(xpath ="//input[@id='Tags']")
	public WebElement WhereTextBox;
	
	@FindBy(xpath ="//ul[@id='ui-id-1']/li/a")
	public WebElement WhereTextBoxDropdown;
	
	@FindBy(xpath = "//a[contains(@class,'ui-state-default ui-state-active')]")
	public WebElement CheckInDate;
	
	@FindBy(xpath ="//td[contains(@class,'range')]//a[contains(@class,'ui-state-default')][contains(text(),'27')]")
	public WebElement CheckOutDate;
	
	@FindBy(xpath ="//select[@id='travellersOnhome']")
	public WebElement TravellersDropDown;
	
	@FindBy(xpath ="//input[@id='SearchHotelsButton']")
	public WebElement SearchBtn;
	
	@FindBy(xpath ="//strong[contains(text(),'(1 night)')]")
	public WebElement SearchResultsHeader;
	
	//Constructor
	
	public HotelPage (WebDriver driver) {
	    PageFactory.initElements(driver, this);
	  }

	 //User Methods
	 
	 public boolean isTitleDisplayed()  {
		    return Title.isDisplayed();
	  }
	 public void ClickonHotelLink()  {
		 Actions act = new Actions(Utilities.getDriver());
		 act.moveToElement(HotelLink).click().build().perform();
	  }
	 public void setTexttoWhereTextBox(String text) {
		 WhereTextBox.sendKeys(text);
		  PageUtils.explicitWait(Utilities.getDriver(), WhereTextBoxDropdown, 2000);
		  Actions act = new Actions(Utilities.getDriver());
		  act.sendKeys(Keys.ENTER);
		  
	  }
	 public void ClickonCheckInDate() {
		 CheckInDate.click();
	  }
	 public void ClickonCheckOutDate(){
		 CheckOutDate.click();
	  }
	 public void SelectTravellersDropDown(String text){
		 Select select = new Select(TravellersDropDown);
		 select.selectByVisibleText(text);
	 }
	 public void ClickonSearchBtn(){
		 SearchBtn.click();
	  }
	 public String getSearchResultsHeader() throws InterruptedException {
		  return SearchResultsHeader.getText();
	  }
	 public boolean isSearchResultsHeaderDisplayed() {
		 PageUtils.explicitWait(Utilities.getDriver(), SearchResultsHeader, 2000);
		    return SearchResultsHeader.isDisplayed();
	  }
}
