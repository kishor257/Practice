package generic;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utility {

	public static WebDriver openBrowser(String ip,String browser){
		WebDriver driver;
		if(ip.equals("localhost")){
			if(browser.equals("chrome")){
				driver=new ChromeDriver();
			}
			else{
				driver=new FirefoxDriver();
			}
		}
		else{
			try{
				URL url=new URL("http://"+ip+":4444/wd/hub");
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setBrowserName(browser);
				driver=new RemoteWebDriver(url,dc);
			}
			catch (Exception e) {
				e.printStackTrace();
				driver=new ChromeDriver();
			}
		}
		return driver;
	}

	public static String getPropertyValue(String path,String key){
		String v="";
		try{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return v;
	}
	//added by me
		public static void writeResultToXL(String path,String sheet,int pass,int fail) {
			try {
				Workbook w = WorkbookFactory.create(new FileInputStream(path));
				w.getSheet(sheet).getRow(1).getCell(0).setCellValue(pass);
				w.getSheet(sheet).getRow(1).getCell(1).setCellValue(fail);
				w.write(new FileOutputStream(path));
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("code not working");
			}
		}

	//below code added by me
	public static String getCellValue(String path,String sheet,int r,int c){
		String value="";
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e){
		}
		return value;
	}
	public static int getRowCount(String path,String sheet){
		int rc=0;
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e){
		}
		return rc;
	}
	//below code added by me
	public static void captureScreenshot(WebDriver driver, String failedTestMethodName){
		try {
			String currentDate = new Date().toString().replaceAll(":", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./screenshots/"+ failedTestMethodName+"__"+ currentDate + ".png");
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {

		}
	}
}
