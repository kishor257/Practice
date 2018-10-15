package script;

import org.testng.annotations.Test;
import generic.BaseTest;
import page.LoginPage;


public class OrangeTC1 extends BaseTest{
	@Test(priority=1,groups={"smoke"})
	public void testA(){
		LoginPage l=new LoginPage(driver);
		l.setUserName("admin");
		l.setPassword("admin123");
		l.clickLogin();
	}
}
















