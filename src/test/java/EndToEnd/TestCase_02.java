//package EndToEnd;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//public class TestCase_02 {
//	
//	public static void main(String[] args) {
//		
//		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
//		
//		driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
//		driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("kirana");
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kirana@gmail.com");
//		driver.findElement(By.xpath("//input[@id='contactno']")).sendKeys("9876543211");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("kirana");
//		driver.findElement(By.xpath("//input[@id='confirmpassword']")).sendKeys("kirana");
//		driver.findElement(By.xpath("//button[.='Sign Up']")).click();
//		
//		wait.until(ExpectedConditions.alertIsPresent()).accept();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='exampleInputEmail1']"))).sendKeys("kirana@gmail.com");
//		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("kirana");
//		driver.findElement(By.xpath("//button[.='Login']")).click();
//		System.out.println("login is successed");
//		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
//		System.out.println("Test Case is passed");
//		driver.quit();
//		
//		
//				
//	 
//		
//		
//		
//	}
//}
