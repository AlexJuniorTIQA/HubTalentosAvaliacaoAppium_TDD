package br.com.rsinet.appium.utils;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

/** Classe de parametrizão dos Drivers **/
public class DriverFactory {
	static AndroidDriver<WebElement> driver;

	/**
	 * Método de parametrização do ChromeDriver, define Link, Espera de Elemento e
	 * Resolução
	 * 
	 * @throws IOException
	 **/
	public static AndroidDriver<WebElement> getDriver() throws IOException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");

		desiredCapabilities.setCapability("appPackage", "com.Advantage.aShopping");
		desiredCapabilities.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");

		// desiredCapabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")
		// + "\\src\\main\\resources\\Advantage+demo+2_0.apk");
		
		desiredCapabilities.setCapability("unicodeKeyboard", true);
		desiredCapabilities.setCapability("resetKeyboard", true);

		driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static AndroidDriver<WebElement> pageRoll() { // 912 1416 828, 178
		(new TouchAction((PerformsTouchActions) driver)).press(PointOption.point(1059, 1744))
				.moveTo(PointOption.point(1055, 378)).release().perform();
		return driver;
	}
	
//	public static void findText(AndroidDriver<WebElement> driver, String visibleText) {
//		driver.findElementByAndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
//						+ visibleText + "\").instance(0))")
//				.click();
//	}


	/**
	 * Metodo de Parametrização do Driver, verifica se há algum aberto e se haver,
	 * fecha o mesmo
	 **/
	public static void quitDriver(WebDriver driver) {
		if (driver != null)
			driver.quit();
	}
}
