package br.com.rsinet.appium.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.appium.pages.HomePage;
import br.com.rsinet.appium.pages.ProductPage;
import br.com.rsinet.appium.pages.RegisterPage;
import br.com.rsinet.appium.utils.Constant;
import br.com.rsinet.appium.utils.DriverFactory;
import br.com.rsinet.appium.utils.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;

public class ConsultaProdutoTelaInicial {
	private AndroidDriver<WebElement> driver;
	private RegisterPage registerPage;
	private HomePage homePage;
	private ProductPage productPage;
	
	

	@Before
	public void Inicializa() throws Exception {
		driver = DriverFactory.getDriver();
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		productPage = PageFactory.initElements(driver, ProductPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Mice");
	}
	@After 
	public void Finaliza() {
		//driver.quit();
	}

	@Test
	public void ConsultaProdutoTelaInicialComSucesso() throws Exception {
		DriverFactory.findVisibleText("Mice");
		DriverFactory.findVisibleText(ExcelUtils.getCellData(6, 1));
		Assert.assertEquals(ExcelUtils.getCellData(6, 1).toUpperCase(), productPage.getTextProduct());
	}
	@Test
	public void ConsultaProdutoTelaInicialComFalha() {
		DriverFactory.findVisibleText("Laptops");
		
		DriverFactory.findVisibleText("HP PAVILION 15Z TOUCH LAPTOP");
		
		productPage.clickSelectColor();
		productPage.clickIconColor();
		
		Assert.assertEquals("HP PAVILION 15Z TOUCH LAPTOP", productPage.getTextProduct());
	}
}
