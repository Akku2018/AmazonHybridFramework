package Amazon.hybridFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractComponent{

	
	public SearchResultPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="span.a-button-text.a-declarative")
	WebElement Filter;
	
	@FindBy(id="s-result-sort-select_1")
	WebElement lowToHighFilter;
	
	@FindBy(className="a-price-whole")
	List<WebElement> Mobileprices;
	
	@FindBy(xpath = "(//button[@name='submit.addToCart'])[1]")
    WebElement SelectProduct;
	
	@FindBy(id="nav-cart-count-container")
	WebElement ClickOnCartButton;
	
	By productBy= By.xpath("(//button[@name='submit.addToCart'])");
	
	By cartButton= By.id("nav-cart-count-container");
	
	public void applyLowToHighFilter() {
		Filter.click();
		lowToHighFilter.click();
	}
	
	public void arePricesSorted() {
		
	List<Integer> price= new ArrayList<>();
	for(WebElement Mobileprice: Mobileprices) {
		try{
		String priceText= Mobileprice.getText().replaceAll("[^0-9]", "");
		if (!priceText.isEmpty()) {
			price.add(Integer.parseInt(priceText));
		}
		} catch (Exception e) {
			
		}
	}
	
		  List<Integer> sortedPrices = new ArrayList<>(price);
	        Collections.sort(sortedPrices);

	        if (price.equals(sortedPrices)) {
	            System.out.println("Prices are sorted from low to high.");
	        } else {
	            System.out.println("Prices are NOT sorted correctly.");
	        }
	}
	        
	     public void addProductToCart() {
	    	
	    	 waitForElement(productBy);
	    	 SelectProduct.click();
	    	 elementToClick(cartButton);
	    	 jsClick(ClickOnCartButton);
	     }

	}


