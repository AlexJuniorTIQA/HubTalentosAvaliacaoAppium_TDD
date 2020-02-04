package br.com.rsinet.appium.teste;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.appium.pages.HomePage;
import br.com.rsinet.appium.pages.RegisterPage;
import br.com.rsinet.appium.utils.AutoCompleteRegisterUser;
import br.com.rsinet.appium.utils.DriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class CadastroNovoUsuario {

	private AndroidDriver<WebElement> driver;
	private RegisterPage registerPage;
	private HomePage homePage;
	private AutoCompleteRegisterUser autoCompleteRegisterUser;
	

	@Before
	public void Inicializa() throws IOException {

			driver = DriverFactory.getDriver();
	}

	@Test
	public void CadastroNovoUsuarioComSucesso() throws Exception {

		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		autoCompleteRegisterUser= new AutoCompleteRegisterUser(driver);
		
		homePage.clickMenu();
		homePage.clickIconUser();
		homePage.clickCreatNewAccount();

		
		autoCompleteRegisterUser.setUserRegister(driver, 1);
//		registerPage.setUserName("Brunoa2");
//		registerPage.setEmail("test@gmail.com.br");
//		registerPage.setPassword("5851.Bruno");
//		registerPage.setConfirmPassword("5851.Bruno");
//
//		registerPage.setFirstName("Bruno");
//		registerPage.setLastName("Rosta");
//		registerPage.setPhoneNumber("4444-99966");
//		
		//DriverFactory.pageRoll();
//		
//		registerPage.selectCountry(driver, "Canada");
//		
//		
//		registerPage.setState("asas");
//		registerPage.setAdress("asas");
//		registerPage.setCity("sasa");
//		registerPage.setPostalCode("5458");
		
		registerPage.clickButtonRegister();
		
		//driver.quit();
	}

}
