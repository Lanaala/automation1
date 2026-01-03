package auth_TestStore;

import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	
	WebDriver driver = new ChromeDriver();
	String TheWebSite = "https://automationteststore.com/";
	String Login = "https://automationteststore.com/index.php?rt=account/login";
	Random rand = new Random();
	String[] FirstName = { "Asmaa", "Lana", "Baraa", "Juman" };
	String[] LastName = { "KH", "KA", "abu", "Mo" };
	int FN = rand.nextInt(FirstName.length);
	int LN = rand.nextInt(LastName.length);
	int num = rand.nextInt(2000);
	String loginName = FirstName[FN] + LastName[LN] + num;
    String passwordString="ajaj12@";
    
	@BeforeTest
	public void MySetup() {

		driver.get(TheWebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
 
	}

	@Test(priority = 1)
	public void signup() throws InterruptedException {

		driver.navigate().to(Login);
		WebElement ContinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
		ContinueButton.click();

	

	
		

		String email = FirstName[FN] + LastName[LN] + num + "@gmail.com";

		WebElement Fname = driver.findElement(By.id("AccountFrm_firstname"));
		Fname.sendKeys(FirstName[FN]);

		WebElement Lname = driver.findElement(By.id("AccountFrm_lastname"));
		Lname.sendKeys(LastName[LN]);

		WebElement myEmail = driver.findElement(By.id("AccountFrm_email"));
		myEmail.sendKeys(email);
		 
		WebElement telephone = driver.findElement(By.id("AccountFrm_telephone"));
		telephone.sendKeys("079");
		
		WebElement fax=driver.findElement(By.id("AccountFrm_fax"));
		fax.sendKeys("123");
		
		WebElement company=driver.findElement(By.id("AccountFrm_company"));
		company.sendKeys("INspire");
		 
		WebElement Address1=driver.findElement(By.id("AccountFrm_address_1"));
		Address1.sendKeys("7 circle");
		
		WebElement address2 =driver.findElement(By.id("AccountFrm_address_2"));
		address2.sendKeys("maka street");
		
		WebElement city =driver.findElement(By.id("AccountFrm_city"));
		city.sendKeys("Amman");
		
		WebElement zipcode=driver.findElement(By.id("AccountFrm_postcode"));
		zipcode.sendKeys("1212");
		
		WebElement countryElement=driver.findElement(By.id("AccountFrm_country_id"));
		int countryrand=rand.nextInt(1,4);
		Select countrySelector =new Select(countryElement);
		countrySelector.selectByIndex(countryrand);
		
		Thread.sleep(4000);
		
		WebElement region =driver.findElement(By.id("AccountFrm_zone_id"));
		Select MySelector=new Select(region);
		int optionsCount = MySelector.getOptions().size();
		int regionstate=rand.nextInt(1,optionsCount);
		MySelector.selectByIndex(regionstate);
		
		WebElement loginNamElement=driver.findElement(By.id("AccountFrm_loginname"));
		loginNamElement.sendKeys(loginName);
		
		WebElement password =driver.findElement(By.id("AccountFrm_password"));
		password.sendKeys(passwordString);
		
		WebElement confirmpassElement=driver.findElement(By.id("AccountFrm_confirm"));
		confirmpassElement.sendKeys(passwordString);
		
		WebElement Subscribe=driver.findElement(By.id("AccountFrm_newsletter1"));
		Subscribe.click();
		
		WebElement privacypolicyElement=driver.findElement(By.id("AccountFrm_agree"));
		privacypolicyElement.click();
		
		WebElement continuElement =driver.findElement(By.xpath("//button[@title='Continue']"));
		continuElement.click();
		
		WebElement continunavigatElement= driver.findElement(By.linkText("Continue"));
				continunavigatElement.click();
	}
	
	
	@Test(priority = 2)
	public void logout() {
		WebElement logoffElement=driver.findElement(By.linkText("Logoff"));
		logoffElement.click();
		WebElement continueAfterLogout = driver.findElement(By.linkText("Continue"));
		continueAfterLogout.click();

		
		
		
		
	}
	@Test(priority = 3)
	public void login() throws InterruptedException {
		Thread.sleep(3000);
		
		driver.navigate().to(Login);
		
		WebElement loginname=driver.findElement(By.id("loginFrm_loginname"));
		loginname.sendKeys(loginName);
		
		driver.findElement(By.id("loginFrm_password")).sendKeys(passwordString);
		
		Thread.sleep(3000);
		
		WebElement loginbuttonElement=driver.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));
		loginbuttonElement.click();
	}

	@AfterTest
	public void AfterDoingTheTest() {

	}
	
	
	
		
	
	
	
	
	
	
	

}
