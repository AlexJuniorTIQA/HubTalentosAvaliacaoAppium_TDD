package br.com.rsinet.appium.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.appium.pages.RegisterPage;
import io.appium.java_client.android.AndroidDriver;



public class AutoCompleteRegisterUser {

	
	final AndroidDriver<WebElement> driver;
	public AutoCompleteRegisterUser(AndroidDriver<WebElement> driver) {

		this.driver = driver;
	}
	
	/**Classe que preenche todos os campos da página de registro(RegisterPage): Recebe como parâmetro um objeto do tipo integer**/
	public void setUserRegister(AndroidDriver<WebElement> driver, int numberUser) throws Exception {

		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Users");

		registerPage.setUserName(ExcelUtils.getCellData(numberUser, 1));
		registerPage.setEmail(ExcelUtils.getCellData(numberUser, 2));
		registerPage.setPassword(ExcelUtils.getCellData(numberUser, 3));
		registerPage.setConfirmPassword(ExcelUtils.getCellData(numberUser, 3));

		registerPage.setFirstName(ExcelUtils.getCellData(numberUser, 4));
		registerPage.setLastName(ExcelUtils.getCellData(numberUser, 5));
		registerPage.setPhoneNumber(ExcelUtils.getCellData(numberUser, 6));

		DriverFactory.pageRoll();
		
		registerPage.selectCountry(driver, ExcelUtils.getCellData(numberUser, 7));
		
		registerPage.setCity(ExcelUtils.getCellData(numberUser, 8));
		registerPage.setAdress(ExcelUtils.getCellData(numberUser, 9));
		registerPage.setState(ExcelUtils.getCellData(numberUser, 10));
		registerPage.setPostalCode(ExcelUtils.getCellData(numberUser, 11));
		
	}
}
