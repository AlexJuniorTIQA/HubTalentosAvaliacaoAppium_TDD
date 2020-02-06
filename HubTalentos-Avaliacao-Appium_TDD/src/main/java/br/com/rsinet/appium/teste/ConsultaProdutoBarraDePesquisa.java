package br.com.rsinet.appium.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.appium.pages.HomePage;
import br.com.rsinet.appium.pages.ProductPage;
import br.com.rsinet.appium.pages.RegisterPage;
import br.com.rsinet.appium.utils.Constant;
import br.com.rsinet.appium.utils.DriverFactory;
import br.com.rsinet.appium.utils.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;

public class ConsultaProdutoBarraDePesquisa {

	private AndroidDriver<WebElement> driver;
	private HomePage homePage;
	private ProductPage productPage;

	@Before
	public void Inicializa() throws Exception {
		driver = DriverFactory.getDriver();

		homePage = PageFactory.initElements(driver, HomePage.class);
		productPage = PageFactory.initElements(driver, ProductPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Headphone");
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

		DriverFactory.pageRollUp();
		productPage.clickProduct();

		Assert.assertEquals(ExcelUtils.getCellData(1, 1).toUpperCase(), productPage.getTextProduct());

	}

	@Test
	public void ConsultaProdutoBarraDePesquisaComFalha() throws Exception {

		homePage.clickIconSearch();

		String product = ExcelUtils.getCellData(6, 1);
		homePage.setSearch(product);

		homePage.clickIconSearch();

		Assert.assertEquals("- No results for \"" + product + "\" -", productPage.getNotFoundProduct());

	}
}
