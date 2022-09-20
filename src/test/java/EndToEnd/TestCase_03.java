//package EndToEnd;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class TestCase_03 {
//
//	public static void main(String[] args) throws AWTException, InterruptedException {
//
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--disable-notifications");
//		WebDriver driver = new ChromeDriver(option);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
//
//		String userName = "anuj.lpu1@gmail.com";
//		String userPassword = "Test@123";
//		driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
//		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(userName);
//		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(userPassword);
//		driver.findElement(By.xpath("//button[.='Login']")).click();
//
//		String product = "ball";
//		driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(product);
//		driver.findElement(By.xpath("//button[@class='search-button']")).click();
//
//		driver.findElement(By.xpath("//div[@class='products']//a[contains(.,'" + product + "')]"
//				+ "/ancestor::div[@class='product-info text-left']"
//				+ "/following-sibling::div[@class='cart clearfix animate-effect']" + "//i[@class='icon fa fa-heart']"))
//				.click();
//		driver.findElement(By.xpath("//a[@href='my-wishlist.php']")).click();
//		driver.findElement(
//				By.xpath("//a[contains(.,'" + product + "')]/ancestor::td/following-sibling::td/a[.='Add to cart']"))
//				.click();
//		driver.findElement(
//				By.xpath("//a[@href='logout.php']/ancestor::li/preceding-sibling::li/a[@href='my-cart.php']")).click();
//		driver.findElement(By
//				.xpath("//a[contains(.,'" + product + "')]/ancestor::td/preceding-sibling::td/input[@type='checkbox']"))
//				.click();
//		driver.findElement(By.xpath("//button[.='PROCCED TO CHEKOUT']")).click();
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		Robot rob = new Robot();
//		rob.keyPress(KeyEvent.VK_CONTROL);
//		rob.keyPress(KeyEvent.VK_T);
//		rob.keyRelease(KeyEvent.VK_CONTROL);
//		rob.keyRelease(KeyEvent.VK_T);
//		Thread.sleep(5000);
//		String parentWindow = driver.getWindowHandle();
//		Set<String> windows = driver.getWindowHandles();
//		for (String wind : windows) {
//			if (!wind.equals(parentWindow)) {
//				driver.switchTo().window(wind);
//			}
//		}
//		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin");
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
//		driver.findElement(By.xpath("//button[.='Login']")).click();
//		driver.findElement(By.xpath("//a[contains(.,'Order Management')]")).click();
//		driver.findElement(By.xpath("//a[contains(.,'Today')]")).click();
//		driver.findElement(By.xpath("//td[contains(.,'" + userName + "')]/following-sibling::td[contains(.,'" + product
//				+ "')]/following-sibling::td/a[@title='Update order']")).click();
//		Thread.sleep(5000);
//		String adminWindow = driver.getWindowHandle();
//		Set<String> windows2 = driver.getWindowHandles();
//		for (String window : windows2) {
//			if (!(window.equals(adminWindow) || window.equals(parentWindow))) {
//				driver.switchTo().window(window);
//				break;
//			}
//		}
//		WebElement dd = driver.findElement(By.xpath("//select"));
//		Select options = new Select(dd);
//		options.selectByVisibleText("Delivered");
//		driver.findElement(By.xpath("//textarea")).sendKeys("order is delivered");
//		driver.findElement(By.xpath("//input[@value='update']")).click();
//		driver.switchTo().alert().accept();
//		driver.close();
//		for (String wind : windows) {
//			if (!wind.equals(parentWindow)) {
//				driver.switchTo().window(wind);
//				driver.close();
//				break;
//			}
//		}
//		driver.switchTo().window(parentWindow);
//		Thread.sleep(5000);
//		driver.findElement(
//				By.xpath("//table[@class='table table-bordered']/tbody//tr[last()]//td//a[@title='Track order']"))
//				.click();
//		Set<String> winds = driver.getWindowHandles();
//		for (String wind : winds) {
//			if (!wind.equals(parentWindow)) {
//				driver.switchTo().window(wind);
//				break;
//			}
//		}
//		String elexpath="//td[.='Status:']/following-sibling::td";
//		String status = driver.findElement(By.xpath(elexpath)).getText();
//		if (status.equals("Delivered")) {
//			System.out.println("testCase is passed");
//		}
//		
//		driver.quit();
//		
//	}
//}
