package br.com.rsinet.appium.utils;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.appium.pages.RegisterPage;
import io.appium.java_client.android.AndroidDriver;

public class AutoCompleteRegisterUser {

	final AndroidDriver<WebElement> driver;

	public AutoCompleteRegisterUser(AndroidDriver<WebElement> driver) {

		this.driver = driver;
	}
	
	public String getUserName(int quantidadeLetra) {
		Random quantidadedeletras = new Random();
		int index;
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVYWXZabcdefghijklmnopqrstuvxwyz0123456789";
		String palavraRandom = "";
		for (int i = 0; i <= quantidadeLetra - 1; i++) {
			index = quantidadedeletras.nextInt(caracteres.length());
			palavraRandom += caracteres.substring(index, index + 1);
		}
		return palavraRandom;
	}


	/**
	 * Classe que preenche todos os campos da p�gina de registro(RegisterPage):
	 * Recebe como par�metro um objeto do tipo integer
	 **/
	public void setUserRegister(AndroidDriver<WebElement> driver, int numberUser) throws Exception {

		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Users");

		registerPage.setUserName(this.getUserName(7));
		registerPage.setEmail(ExcelUtils.getCellData(numberUser, 2));
		registerPage.setPassword(ExcelUtils.getCellData(numberUser, 3));
		registerPage.setConfirmPassword(ExcelUtils.getCellData(numberUser, 3));

		registerPage.setFirstName(ExcelUtils.getCellData(numberUser, 4));
		registerPage.setLastName(ExcelUtils.getCellData(numberUser, 5));
		registerPage.setPhoneNumber(ExcelUtils.getCellData(numberUser, 6));

		DriverFactory.pageRollDawn();

		registerPage.selectCountry(driver, ExcelUtils.getCellData(numberUser, 7));
		registerPage.setState(ExcelUtils.getCellData(numberUser, 8));
		registerPage.setAdress(ExcelUtils.getCellData(numberUser, 9));
		registerPage.setCity(ExcelUtils.getCellData(numberUser, 10));
		registerPage.setPostalCode(ExcelUtils.getCellData(numberUser, 11));

	}
	public void setAccountDetailsUserRegister(AndroidDriver<WebElement> driver, int numberUser) throws Exception {

		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Users");

		registerPage.setUserName(this.getUserName(7));
		registerPage.setEmail(ExcelUtils.getCellData(numberUser, 2));
		registerPage.setPassword(ExcelUtils.getCellData(numberUser, 3));
		registerPage.setConfirmPassword(ExcelUtils.getCellData(numberUser, 3));
	}
	
}
