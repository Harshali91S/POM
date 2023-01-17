package TestScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import BrowserStackPages.Day2_BrowserStackDashboardPage;
import BrowserStackPages.Day2_BrowserStackSigninPage;

public class Day2_DashboardTest {
	public WebDriver driver;
	Day2_BrowserStackSigninPage bssip;
	Day2_BrowserStackDashboardPage bsdp;
  @Test(priority = 1)
  public void loginTest() {
	  bssip = new Day2_BrowserStackSigninPage(driver);
	  bssip.enterUserEmail("harshali.sonawane0702@gmail.com");
	  bssip.enterUserPassword("Harshali@91");
	  bssip.ClickonLogin();
  }
  @Test(priority = 2)
  public void DashBoardTest() {
	  bsdp = new Day2_BrowserStackDashboardPage(driver);
	  bsdp.UserProfileClick();
	  bsdp.ClickonSummary();
	  Assert.assertEquals(bsdp.verifyUserName(),"Harshali Sonawane");
  }
  @BeforeTest
  public void setup() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  driver.get("https://www.browserstack.com/users/sign_in");  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
