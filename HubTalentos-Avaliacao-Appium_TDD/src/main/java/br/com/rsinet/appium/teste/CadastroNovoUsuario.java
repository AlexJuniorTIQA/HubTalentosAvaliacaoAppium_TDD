package br.com.rsinet.appium.teste;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.appium.pages.RegisterPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CadastroNovoUsuario {

	WebDriver driver;
	
	@Before
	public void Inicializa() throws IOException {

	}

	@Test
	public void CadastroNovoUsuarioComSucesso() throws MalformedURLException {

		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

		driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu")).click();

		driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).click();
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewDontHaveAnAccount")).click();

		
		registerPage.setUserName("asas");
		registerPage.setEmail("ASAS");
		registerPage.setPassword("as");
		registerPage.setConfirmPassword("as");

		driver.quit();
	}

}
