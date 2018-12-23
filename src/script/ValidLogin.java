package script;


import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest{

	@Test(priority=1,groups={"login","smoke"})
	public void testValidLogin()
	{
		String un=Utility.getCellValue(XL_PATH,"ValidLogin",1,0);
		String pw=Utility.getCellValue(XL_PATH,"ValidLogin",1,1);
		String title=Utility.getCellValue(XL_PATH,"ValidLogin",1,2);
		String sETO = Utility.getPropertyValue(CONFIG_PATH,"ETO");
		long lETO = Long.parseLong(sETO);
		//		Enter valid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//		Enter valid password
		l.setPassword(pw);
		//		click on login
		l.clickLogin();
		//		verify Home page is displayed
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(driver,"actiTIME - Enter Time-Track",10);
	}
}
