package Amazon.hybridFramework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

public class Practice {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#twotabsearchtextbox.nav-input.nav-progressive-attribute")).sendKeys("Laptop");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.className("a-dropdown-prompt")).click();
		driver.findElement(By.xpath("//a[text()='Price: High to Low']")).click();
		
List<WebElement> laptopPrices=driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price-whole']"));
List<Integer> price= new ArrayList<>();
		for(WebElement laptopPrice:laptopPrices) {
			try {
				String priceText= laptopPrice.getText().replaceAll("[^0-9]", "");
				if(!priceText.isEmpty()) {
					price.add(Integer.parseInt(priceText));
				}
			}
			catch(Exception e) {
		}
	}
		List<Integer> sortedPrice=new ArrayList<>(price);
		sortedPrice.sort(Comparator.reverseOrder());
		if(price.equals(sortedPrice)) {
			System.out.println("Price is sorted");
		}
		else {
			System.out.println("Price is not sorted");
		}

}
}
