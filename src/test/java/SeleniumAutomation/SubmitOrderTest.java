package SeleniumAutomation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation.pageobjects.CartPage;
import Automation.pageobjects.CheckoutPage;
import Automation.pageobjects.ConfirmationPage;
import Automation.pageobjects.OrderPage;
import Automation.pageobjects.ProductCatalogue;
import automation.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	//String productName="ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"testng"})
	public void submitOrder(HashMap<String,String>input) throws InterruptedException, IOException
	{		// TODO Auto-generated method stub
 ProductCatalogue productCatalogue=landingpage.loginApp(input.get("email"),input.get("password"));
 
 //List<WebElement> products=productCatalogue.getProductsList();
 productCatalogue.addProductToCart(input.get("product"));
 CartPage cartPage=productCatalogue.goToCartPage();
 Boolean match =cartPage.VerifyProductDisplay(input.get("product"));
	Assert.assertTrue(match);
	CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectcountry("india");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
			String confirmMessage=confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confirmMessage.contains("THANKYOU"));			
			
			
			}
	
@Test
	//@Test(dependsOnMethods= {"submitOrder"})
	/*public void OrderHistory()
		{
		String productName="ZARA COAT 3";
		 ProductCatalogue productCatalogue=landingpage.loginApp("reema123@gmail.com","Reema@1994");
		OrderPage orderPage= productCatalogue.gotoOrdersPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
		System.out.println(productName);

		}*/
	
	
	@DataProvider
	public Object[] [] getData() throws IOException
	{
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\automation\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	}

	

	


