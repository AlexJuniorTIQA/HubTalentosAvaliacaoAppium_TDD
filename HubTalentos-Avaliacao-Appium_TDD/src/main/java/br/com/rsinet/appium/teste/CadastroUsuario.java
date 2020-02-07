package br.com.rsinet.appium.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.appium.screens.HomeScreen;
import br.com.rsinet.appium.screens.LoginScreen;
import br.com.rsinet.appium.screens.RegisterScreen;
import br.com.rsinet.appium.utils.AutoCompleteRegisterUser;
import br.com.rsinet.appium.utils.Constant;
import br.com.rsinet.appium.utils.DriverFactory;
import br.com.rsinet.appium.utils.ExcelUtils;
import br.com.rsinet.appium.utils.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

public class CadastroUsuario {

	private AndroidDriver<WebElement> driver;
	private RegisterScreen registerPage;
	private HomeScreen homePage;
	private LoginScreen loginScreen;
	private AutoCompleteRegisterUser autoCompleteRegisterUser;
	private String teste;
	private ExtentTest report;
    static ExtentReports test;
	
	
    @BeforeClass
    public static void test() {
        test = ExtentReport.setExtent("Cadastro Novo Usuario");
    }
	@Before
	public void Inicializa() throws Exception {

	
		driver = DriverFactory.getDriver();
		registerPage = PageFactory.initElements(driver, RegisterScreen.class);
		loginScreen = PageFactory.initElements(driver, LoginScreen.class);
		homePage = PageFactory.initElements(driver, HomeScreen.class);
		autoCompleteRegisterUser= new AutoCompleteRegisterUser(driver);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister, "Users");
	}
	@After
	public void Finaliza() {
		ExtentReport.quitExtent(test);
		driver.quit();
	}

	@Test
	public void CadastroNovoUsuarioComSucesso() throws Exception {
		report = ExtentReport.createTest("CadastroNovoUsuarioComSucesso");
		homePage.clickMenu();
		homePage.clickIconUser();
		loginScreen.clickCreatNewAccount();

		autoCompleteRegisterUser.setUserRegister(driver, 1);

		registerPage.clickButtonRegister();
		
		
		DriverFactory.pageRollUp();
		homePage.clickMenu();
		
		Assert.assertNotEquals("LOGIN", homePage.getIconUser()); 
		
		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteCadastroNovoUsuarioComSucesso";
	}
	@Test
	public void CadastroNovoUsuarioComFalha() throws Exception {
		report = ExtentReport.createTest("CadastroNovoUsuarioComFalha");
		
		homePage.clickMenu();
		homePage.clickIconUser();
		loginScreen.clickCreatNewAccount();


		registerPage.setUserName(autoCompleteRegisterUser.getUserName(7));
		registerPage.setEmail(ExcelUtils.getCellData(4, 2));
		registerPage.setPassword(ExcelUtils.getCellData(4, 3));
		registerPage.setConfirmPassword(ExcelUtils.getCellData(4, 3));
		
		Assert.assertEquals("1 upper letter required", registerPage.getIconPassword());
		
		ExtentReport.statusReported(report, driver, teste);
		teste = "TesteCadastroNovoUsuarioComFalha";
	}
}
