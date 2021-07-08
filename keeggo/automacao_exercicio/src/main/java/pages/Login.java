package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Login {

	private static WebDriver driver;

	private By txtNome = By.name("username");
	
	private By txtSenha = By.name("password");
	
	private By btnEntrar = By.id("sign_in_btnundefined");
	
	private By txtAlerta = By.cssSelector("label.invalid");
	
	private By opcCriarConta = By.xpath("//a[contains(text(),'CREATE NEW ACCOUNT')]");

	private By btnCadastro = By.cssSelector("a[class=\"create-new-account ng-scope\"]");

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public CriarCadastro clicarCadastro() {
		driver.findElement(btnCadastro).click();
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(java.lang.NullPointerException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(opcCriarConta));

		return new CriarCadastro(driver);
	}

	public void preencherNome(String nome) {
		driver.findElement(txtNome).sendKeys(nome);
	}

	public void preencherSenha(String senha) {
		driver.findElement(txtSenha).sendKeys(senha);
	}

	public void clicarBotaoEntrar() {
		driver.findElement(btnEntrar).click();

	}

	public boolean mensagemAlerta(String menssagem) {
		return menssagem.contentEquals(driver.findElement(txtAlerta).getText());
	}

	public void clicarSenha() {
		driver.findElement(txtSenha).sendKeys(Keys.TAB);
	}

}
