package br.com.rsinet.appium.teste;

import java.io.IOException;
import java.sql.Driver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.appium.pages.HomePage;
import br.com.rsinet.appium.pages.ProductPage;
import br.com.rsinet.appium.pages.RegisterPage;
import br.com.rsinet.appium.utils.AutoCompleteRegisterUser;
import br.com.rsinet.appium.utils.Constant;
import br.com.rsinet.appium.utils.DriverFactory;
import br.com.rsinet.appium.utils.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;

public class ConsultaProdutoBarraDePesquisa {

	private AndroidDriver<WebElement> driver;
	private RegisterPage registerPage;
	private HomePage homePage;
	private ProductPage productPage;
	
	

	@Before
	public void Inicializa() throws Exception {
		driver = DriverFactory.getDriver();
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Mice");
	}
	@After
	public void Finaliza() {
		driver.quit();
	}

	@Test
	public void ConsultaProdutoBarraDePesquisaComSucesso() throws Exception {
		homePage.clickIconSearch();
		homePage.setSearch(ExcelUtils.getCellData(1, 1));
		homePage.clickIconSearch();
		
		Assert.assertEquals(ExcelUtils.getCellData(1, 1).toUpperCase(),driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).getText());

	}
	
	@Test
	public void ConsultaProdutoBarraDePesquisaComFalha() throws Exception {
		
		homePage.clickIconSearch();
		homePage.setSearch(ExcelUtils.getCellData(1, 10));
		homePage.clickIconSearch();
		
			
	}
}
