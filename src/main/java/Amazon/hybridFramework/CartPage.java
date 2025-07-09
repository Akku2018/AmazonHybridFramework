package Amazon.hybridFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponent{
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="proceedToRetailCheckout")
	WebElement Checkout;
	
	By waitForCart = By.name("proceedToRetailCheckout");
	
	public void CheckOut() {
		waitForElement(waitForCart);
		Checkout.click();
	}

}
