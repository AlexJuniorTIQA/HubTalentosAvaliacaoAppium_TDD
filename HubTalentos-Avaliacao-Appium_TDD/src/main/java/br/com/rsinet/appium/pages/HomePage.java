package br.com.rsinet.appium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Classe de mapeamento de elementos: HomePage do app AdvantageOnlineShopping
 **/
public class HomePage {

	final WebDriver driver;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")

	public WebElement elementMenu;
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")

	public WebElement elementIconUser;

	@FindBy(how = How.ID, using = "")

	private WebElement elementIconSearch;

	@FindBy(how = How.ID, using = "")

	private WebElement elementSearch;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewDontHaveAnAccount")

	private WebElement elementCreatNewAccount;

	@FindBy(how = How.ID, using = "")

	private WebElement elementTablets;

	@FindBy(how = How.ID, using = "")

	private WebElement elementHeadPhones;

	@FindBy(how = How.ID, using = "")

	private WebElement elementSpeakers;

	@FindBy(how = How.ID, using = "")

	private WebElement elementLaptops;

	@FindBy(how = How.ID, using = "")

	private WebElement elementMice;

	@FindBy(how = How.XPATH, using = "")
	private WebElement elementUserLink;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}
	/** Retorna um click ao Icone Menu do app **/
	public void clickMenu() {
		elementMenu.click();
	}
	/** Retorna um click ao Icone de Usuário **/
	public void clickIconUser() {
		elementIconUser.click();
	}

	/** Retorna um click ao Icone de Criar Nova Conta **/
	public void clickCreatNewAccount() {
		elementCreatNewAccount.click();;
	}
}
