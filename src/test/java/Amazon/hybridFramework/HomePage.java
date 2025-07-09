package Amazon.hybridFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractComponent{
	
    WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="field-keywords")
	WebElement searchInput;
	
	@FindBy(id= "nav-search-submit-button")
	WebElement clickSearchButton;
	
	By ProductBy= By.name("field-keywords");
	
	public void searchProduct(String product)
	{
		waitForElement(ProductBy);
		searchInput.sendKeys(product);
		
		clickSearchButton.click();
		
	}
	
	
	

}
