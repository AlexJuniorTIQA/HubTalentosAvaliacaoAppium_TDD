package br.com.rsinet.appium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Classe de mapeamento de elementos: Página de Produtos do site
 * AdvantageOnlineShopping
 **/
public class ProductPage {

	final WebDriver driver;

	@FindBy(how = How.XPATH, using = "")
	private WebElement elementProductName;



	@FindBy(how = How.XPATH, using = "/")
	private WebElement elementNotFound;



	public ProductPage(WebDriver driver) {

		this.driver = driver;
	}

	

}
