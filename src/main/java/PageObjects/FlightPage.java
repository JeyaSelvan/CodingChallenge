package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtils;
import Utilities.Utilities;


public class FlightPage {

	//Locators
	
	@FindBy(xpath ="//h1[contains(text(),'Search flights')]")
	public WebElement Title;
	
	@FindBy(xpath ="//input[@id='OneWay']")
	public WebElement OneWayRadioBtn;
	
	@FindBy(xpath ="//input[@id='FromTag']")
	public WebElement FromTextBox;
	
	@FindBy(xpath ="//ul[@id='ui-id-1']/li/a")
	public WebElement FromTextBoxDropdown;
	
	@FindBy(xpath ="//input[@id='ToTag']")
	public WebElement ToTextBoxDropdown;
	
	@FindBy(xpath = "//ul[@id='ui-id-2']/li/a")
	public WebElement ToTextBox;
	
	@FindBy(xpath = "//input[@id='DepartDate']")
	public WebElement DepartDate;
	
	@FindBy(xpath ="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[4]")
	public WebElement DatePick;
	
	@FindBy(xpath ="//input[@id='SearchBtn']")
	public WebElement SearchBtn;
	
	@FindBy(xpath ="//div[@class='ctCol ctCenter']")
	public WebElement SearchResultsHeader;
	
	//Constructor
	
	public FlightPage (WebDriver driver) {
	    PageFactory.initElements(driver, this);
	  }
  
	 
	 //User Methods
	 
	 public boolean isTitleDisplayed()  {
		    return Title.isDisplayed();
	  }
	 public void ClickonOneWayRadioBtn() {
		 OneWayRadioBtn.click();
	  }
	 public void setTexttoFromTextBox(String text)  {
		 FromTextBox.sendKeys(text);
		  PageUtils.explicitWait(Utilities.getDriver(), FromTextBoxDropdown, 2000);
		  Actions act = new Actions(Utilities.getDriver());
		  act.sendKeys(Keys.ARROW_DOWN);
		  act.sendKeys(Keys.ENTER);
		  
	  }
	 public void setTexttoToTextBox(String text)  {
		 ToTextBox.sendKeys(text);
		  PageUtils.explicitWait(Utilities.getDriver(), ToTextBoxDropdown, 2000);
		  Actions act = new Actions(Utilities.getDriver());
		  act.sendKeys(Keys.ARROW_DOWN);
		  act.sendKeys(Keys.ENTER);
	  }
	 public void ClickonDepartDate()  {
		 DepartDate.click();
	  }
	 public void ClickonDatePick()  {
		 DatePick.click();
	  }
	 public void ClickonSearchBtn() {
		 SearchBtn.click();
	  }
	 public String getSearchResultsHeader() throws InterruptedException {
		  return SearchResultsHeader.getText();
	  }
	 public boolean isSearchResultsHeaderDisplayed()  {
		 PageUtils.explicitWait(Utilities.getDriver(), SearchResultsHeader, 2000);
		    return SearchResultsHeader.isDisplayed();
	  }

}
