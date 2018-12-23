package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement helpMenu;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutMenu;
	
	@FindBy(xpath="//span[starts-with(.,'actiTIME')]")
	private WebElement productVersion;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeButton;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	
	public EnterTimeTrackPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void verifyTitle(WebDriver driver,String eTitle){
		String aTitle=driver.getTitle();
		Assert.assertEquals(aTitle, eTitle);
	}
	
	public void verifyTitle(WebDriver driver,String eTitle,long timeOut){
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		try{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching",true);
		}
		catch (Exception e) {
			Reporter.log("Title is NOT matching",true);
			Assert.fail();
		}
		
	}
	public void clickHelp(){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		helpMenu.click();
	}
	
	public void clickAboutActiTIME(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aboutMenu.click();
	}
	
	public void verifyProductVersion(String eVersion){
		String aVersion=productVersion.getText();
		Assert.assertEquals(aVersion, eVersion);
		
	}
	
	public void clickCloseButton(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeButton.click();
	}
	
	public void clickLogout(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logoutLink.click();
	}	
}


