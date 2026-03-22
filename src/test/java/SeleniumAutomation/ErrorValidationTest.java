package SeleniumAutomation;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.pageobjects.CartPage;
import Automation.pageobjects.ProductCatalogue;
import automation.TestComponents.BaseTest;
import automation.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {

	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws InterruptedException, IOException
	{
//String productName="ZARA COAT 3";
 landingpage.loginApp("reem123@gmail.com","Reema@1994");
 Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}

@Test
	public void ProductErrorValidation() throws InterruptedException, IOException
	{		// TODO Auto-generated method stub
String productName="ZARA COAT 3";
 ProductCatalogue productCatalogue=landingpage.loginApp("reema123@gmail.com","Reema@1994");
 
// List<WebElement> products=productCatalogue.getProductsList();
 productCatalogue.addProductToCart(productName);
 CartPage cartPage=productCatalogue.goToCartPage();
 Boolean match =cartPage.VerifyProductDisplay("ZARA COAT 33");
	Assert.assertFalse(match);
	
			
			}

}
