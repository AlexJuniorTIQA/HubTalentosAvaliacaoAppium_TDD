package br.com.rsinet.appium.utils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/** Classe de parametrizão dos Drivers **/
public class DriverFactory {
	static WebDriver driver;

	/**
	 * Método de parametrização do ChromeDriver, define Link, Espera de Elemento e
	 * Resolução
	 * @throws IOException 
	 **/
	public static WebDriver getDriver() throws IOException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");

		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\alex.junior\\Desktop\\Eclipse\\CursoAppium\\src\\main\\resources\\Advantage+demo+2_0.apk");

		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

	/**
	 * Metodo de Parametrização do Driver, verifica se há algum aberto e se haver,
	 * fecha o mesmo
	 **/
	public static void quitDriver(WebDriver driver) {
		if (driver != null)
			driver.quit();
	}
}
