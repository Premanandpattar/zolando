package EndToEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.zolando.practies.FetchDataFromPropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_01 {

	public static void main(String[] args) {

//		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
//		driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("Test@123");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(FetchDataFromPropertiesFile.FetchValue("urlForAdmin"));
		driver.findElement(By.id("inputEmail")).sendKeys(FetchDataFromPropertiesFile.FetchValue("adminUN"));
		driver.findElement(By.id("inputPassword")).sendKeys(FetchDataFromPropertiesFile.FetchValue("adminPass"));
		driver.findElement(By.xpath("//button[.='Login']")).click();

		driver.findElement(By.xpath("//a[@href='category.php']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter category Name']")).sendKeys("Pets Food");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("good quality food");
		driver.findElement(By.xpath("//button[@class='btn']")).click();

		WebElement dd_show = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
		Select opt1 = new Select(dd_show);
		opt1.selectByVisibleText("100");

		if (driver.findElement(By.xpath("//td[.='Pets Food']")).getText().equals("Pets Food")) {
			System.out.println("category was created");
		} else {
			System.out.println("category was not created test case fail");
			driver.quit();
		}

		driver.findElement(By.xpath("//a[@href='subcategory.php']")).click();
		WebElement dd_category = driver.findElement(By.xpath("//select[@name='category']"));
		Select opt2 = new Select(dd_category);
		opt2.selectByVisibleText("Pets Food");
		driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys("Cat");
		driver.findElement(By.xpath("//button[@class='btn']")).click();

		WebElement dd_show1 = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
		Select opt3 = new Select(dd_show1);
		opt3.selectByVisibleText("100");

		if (driver.findElement(By.xpath("//td[.='Cat']")).getText().equals("Cat")) {
			System.out.println("sub category was created");
		} else {
			System.out.println("sub category was not created test case fail");
			driver.quit();
		}

		driver.findElement(By.xpath("//a[@href='insert-product.php']")).click();
		WebElement dd_category1 = driver.findElement(By.xpath("//select[@name='category']"));
		Select opt4 = new Select(dd_category1);
		opt4.selectByVisibleText("Pets Food");

		WebElement dd_subCategory = driver.findElement(By.xpath("//select[@id='subcategory']"));
		Select opt5 = new Select(dd_subCategory);
		opt5.selectByVisibleText("Cat");

		driver.findElement(By.xpath("//input[@name='productName']")).sendKeys("Milk");
		driver.findElement(By.xpath("//input[@name='productCompany']")).sendKeys("Nadini");
		driver.findElement(By.xpath("//input[@name='productpricebd']")).sendKeys("35");
		driver.findElement(By.xpath("//input[@name='productprice']")).sendKeys("30");
		driver.findElement(By.xpath("//textarea[@name='productDescription']")).sendKeys("1 ltr 100% cow milk");
		driver.findElement(By.xpath("//input[@name='productShippingcharge']")).sendKeys("10");

		WebElement dd_productAvailability = driver.findElement(By.xpath("//select[@id='productAvailability']"));
		Select opt6 = new Select(dd_productAvailability);
		opt6.selectByVisibleText("In Stock");

		driver.findElement(By.xpath("//input[@id='productimage1']"))
				.sendKeys("C:\\Users\\PREM\\Desktop\\shopping portal\\images\\milk1.jpg");
		driver.findElement(By.xpath("//input[@name='productimage2']"))
				.sendKeys("C:\\Users\\PREM\\Desktop\\shopping portal\\images\\milk2.jpg");
		driver.findElement(By.xpath("//input[@name='productimage3']"))
				.sendKeys("C:\\Users\\PREM\\Desktop\\shopping portal\\images\\milk3.jpg");
		driver.findElement(By.xpath("//button[.='Insert']")).click();

		driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
		WebElement dd_show2 = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
		Select opt7 = new Select(dd_show2);
		opt7.selectByVisibleText("100");

		if (driver.findElement(By.xpath("//td[.='Milk']")).getText().equals("Milk")) {
			System.out.println("product was inserted");
		} else {
			System.out.println("product was not inserted test case fail");
			driver.quit();
		}

		driver.findElement(By.xpath("//img[@class='nav-avatar']")).click();
		driver.findElement(By.xpath("//a[.='Logout']")).click();

		System.out.println("Test case is passed");

		driver.quit();

	}
}
