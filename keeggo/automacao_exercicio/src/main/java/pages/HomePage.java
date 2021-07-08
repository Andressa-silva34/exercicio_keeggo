package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage {

	private static WebDriver driver;

	private By paginaLogada = By.cssSelector("span.containMiniTitle");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean paginaLogadaSucesso(String usuario) {
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(java.lang.NullPointerException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(paginaLogada));

		return usuario.contentEquals(driver.findElement(paginaLogada).getText());
	}
}
