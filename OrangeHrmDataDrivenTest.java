package DatadriverTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Helper_ReusableCode.Utility;

public class OrangeHrmDataDrivenTest{

WebDriver driver;
@Test(priority=1,dataProvider="Exceldata",dataProviderClass=Customdata.class)

public void Logintest(String un,String psw)
{
SoftAssert  softAssert=new SoftAssert();
  //create driver session
  driver=new ChromeDriver();
  //global wait
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  
  driver.findElement(By.name("username")).sendKeys(un);
  driver.findElement(By.name("password")).sendKeys(psw);
  //Utility.getscreenshot(driver);
  driver.findElement(By.className("oxd-button")).click();
  Utility.getscreenshot(driver);
  
 driver.findElement(By.linkText("Forgot your password? ")).click();
 driver.findElement(By.name("username")).sendKeys("Admin");
 Utility.getscreenshot(driver);
 driver.findElement(By.xpath("//div[.=' Reset Password ']")).click();
Utility.getscreenshot(driver);
 
     softAssert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login failed");
	 System.out.println("Login completed");
	 softAssert.assertAll();  
	 
}

	@Test(dependsOnMethods={"Logintest"}) 
	 public void Logouttest()
	 {
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		driver.findElement(By.linkText("Logout")).click();
		Utility.getscreenshot(driver);
	 }
}

  




