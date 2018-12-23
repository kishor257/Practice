package script;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Result;
import generic.Utility;
import page.LoginPage;

@Listeners(Result.class)
public class InvalidLogin extends BaseTest{
	
	@Test(priority=2,groups={"login"},enabled=true)
	public void testInvalidLogin(){
		int rc=Utility.getRowCount(XL_PATH,"InvalidLogin");
		for(int i=1;i<=rc;i++){
		String un=Utility.getCellValue(XL_PATH,"InvalidLogin",i,0);
		String pw=Utility.getCellValue(XL_PATH,"InvalidLogin",i,1);
		//Enter invalid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//Enter invalid password
		l.setPassword(pw);
		//click on login
		l.clickLogin();
		//verify that err msg is displayed
		l.verifyErrMsgIsDisplayed();
		}
	}
}
