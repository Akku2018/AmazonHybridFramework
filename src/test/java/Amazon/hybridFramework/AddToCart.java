package Amazon.hybridFramework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddToCart extends BaseTest{

	
	@Test
	public void addProductToCartAndCheckout() {
		HomePage homepage= new HomePage(driver);
		homepage.searchProduct("Mobile");
		SearchResultPage srp= new SearchResultPage(driver);
		srp.applyLowToHighFilter();
		srp.arePricesSorted();
		srp.addProductToCart();
		CartPage cp= new CartPage(driver);
		cp.CheckOut();
	
	       
	    }
	}
	

	


