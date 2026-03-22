package Testing;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RahulShettyAceademy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		System.out.println("Url opened");
		System.out.println("Git Repo");

		driver.quit();
		
		
	}

}
