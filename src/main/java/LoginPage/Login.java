package LoginPage;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username :");
		String username = sc.next();
		System.out.println("Enter Password :");
		String password = sc.next();
		driver.get("http://www.hcltss-lms.com/login/index.php");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginbtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elem = driver.findElement(By.id("page"));
		wait.until(ExpectedConditions.visibilityOf(elem));
		driver.navigate().to("http://www.hcltss-lms.com/local/lmsreports/scorecard.php");
		

		List<WebElement> els = driver.findElements(By.id("pmsacordian"));
		for (WebElement e : els) {
			String unformText = e.getText();

			String[] x = unformText.split("\n");
			for (int i = 0; i < x.length; i++) {
				if (i != 0) {
					if (i % 2 != 0) {
						System.out.println(x[i]);
					} else {
						System.out.print(x[i] + " ");
					}
				} else {
					System.out.println(x[i]);
				}
			}
			System.out.println();

		}
		driver.quit();
	}
}
