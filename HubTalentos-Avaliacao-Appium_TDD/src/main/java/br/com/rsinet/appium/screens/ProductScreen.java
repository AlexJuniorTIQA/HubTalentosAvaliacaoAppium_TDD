package br.com.rsinet.appium.screens;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe de mapeamento de elementos: Página de Produtos do site
 * AdvantageOnlineShopping
 **/
public class ProductScreen {

	final WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewProductName")
	private WebElement elementProductName;
	

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewNoProductsToShow")
	private WebElement elementNotFound;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewFilter")
	private WebElement elementFilter;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/frameLayoutProductColor")
	private WebElement elementSelectColor;
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]")
	private WebElement elementIconColor;
	
	public ProductScreen(WebDriver driver) {

		this.driver = driver;
	}

	public void clickProduct() {
		elementProductName.click();
	}
	public String getTextProduct() {
		return elementProductName.getText();
	}
	public String getNotFoundProduct() {
		return elementNotFound.getText();
	}
	public void clickFilter() {
		elementFilter.click();
	}
	public void clickSelectColor() {
		elementSelectColor.click();
	}
	public void clickIconColor() {
		elementIconColor.click();
	}
}
