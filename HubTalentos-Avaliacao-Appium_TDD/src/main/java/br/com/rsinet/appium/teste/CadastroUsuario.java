package br.com.rsinet.appium.teste;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.appium.pages.HomePage;
import br.com.rsinet.appium.pages.RegisterPage;
import br.com.rsinet.appium.utils.AutoCompleteRegisterUser;
import br.com.rsinet.appium.utils.DriverFactory;
import br.com.rsinet.appium.utils.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;

public class CadastroUsuario {

	private AndroidDriver<WebElement> driver;
	private RegisterPage registerPage;
	private HomePage homePage;
	private AutoCompleteRegisterUser autoCompleteRegisterUser;
	
	

	@Before
	public void Inicializa() throws IOException {

	
		driver = DriverFactory.getDriver();
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		autoCompleteRegisterUser= new AutoCompleteRegisterUser(driver);
	}
	@After
	public void Finaliza() {
		driver.quit();
	}

	@Test
	public void CadastroNovoUsuarioComSucesso() throws Exception {
	
		homePage.clickMenu();
		homePage.clickIconUser();
		homePage.clickCreatNewAccount();

		autoCompleteRegisterUser.setUserRegister(driver, 1);

		registerPage.clickButtonRegister();
		
		
		Thread.sleep(3000);
		homePage.clickMenu();
		
		Assert.assertNotEquals("LOGIN", homePage.getIconUser()); 
	}
	@Test
	public void CadastroNovoUsuarioComFalha() throws Exception {
		homePage.clickMenu();
		homePage.clickIconUser();
		homePage.clickCreatNewAccount();

		autoCompleteRegisterUser.setAccountDetailsUserRegister(driver, 4);

		Assert.assertEquals("1 upper letter required", registerPage.getIconPassword());
	}
}
