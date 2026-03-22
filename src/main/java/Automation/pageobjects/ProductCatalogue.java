package Automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponenents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
	
public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
@FindBy(css=".mb-3")
List<WebElement> products;   //because there are many elements in the list so we will not put findelements instead will put list

@FindBy(css=".ng-animating")
WebElement spinner;  

By productsBy=By.cssSelector(".mb-3");
By addToCart =By.cssSelector(".card-body button:last-of-type");
By toastMessage =By.cssSelector("#toast-container"); 
	
	
	public List<WebElement> getProductsList()
	
	{
		waitForElementToAppear(productsBy);
		return products;
	}

	

	public WebElement getProductByName(String productName)
	{
		WebElement prod=getProductsList().stream().filter(product-> 
		 product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		 return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}
	

	

	
		
	

}
