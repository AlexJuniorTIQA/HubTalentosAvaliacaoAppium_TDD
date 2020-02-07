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
public class LoginScreen {

	final WebDriver driver;
	private WebDriverWait wait;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewDontHaveAnAccount")
	private WebElement elementCreatNewAccount;

	public LoginScreen(WebDriver driver) {

		this.driver = driver;
	}
	/**Retorna um click ao elemento Creat New Account**/
	public void clickCreatNewAccount() {
		elementCreatNewAccount.click();
		;
	}
}
