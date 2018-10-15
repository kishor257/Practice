package generic;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

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
	
	
}
