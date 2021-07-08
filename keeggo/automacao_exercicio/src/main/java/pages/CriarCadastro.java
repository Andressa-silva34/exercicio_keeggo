package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CriarCadastro {

	private static WebDriver driver;

	private By txtNomeCadastro = By.name("usernameRegisterPage");

	private By txtEmailCadastro = By.name("emailRegisterPage");

	private By txtSenhaCadastro = By.name("passwordRegisterPage");

	private By txtConfirmaSenhaCadastro = By.name("confirm_passwordRegisterPage");

	private By txtPrimeiroNomeCadastro = By.name("first_nameRegisterPage");

	private By txtUltimoNomeCadastro = By.name("last_nameRegisterPage");

	private By txtTelefoneCadastro = By.name("phone_numberRegisterPage");

	private By cmbPaisCadastro = By.name("countryListboxRegisterPage");

	private By opcPaisCadastro = By.xpath("//div/select/option[contains(text(),'Brazil')]");

	private By txtCidadeCadastro = By.name("cityRegisterPage");

	private By txtEnderecoCadastro = By.name("addressRegisterPage");

	private By txtEstadoCadastro = By.name("state_/_province_/_regionRegisterPage");

	private By txtCepCadastro = By.name("postal_codeRegisterPage");

	private By chkCorcordo = By.cssSelector("input[name=i_agree]");

	private By btnRegistrar = By.cssSelector("#register_btnundefined");

	private By txtAlertaCadastro = By.cssSelector("label.invalid");

	public CriarCadastro(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherNome(String nome) {
		driver.findElement(txtNomeCadastro).sendKeys(nome);
	}

	public void preencherEmail(String email) {
		driver.findElement(txtEmailCadastro).sendKeys(email);
	}

	public void preencherSenha(String senha) {
		driver.findElement(txtSenhaCadastro).sendKeys(senha);
	}

	public void preencherConfirmaSenha(String senha_confirmacao) {
		driver.findElement(txtConfirmaSenhaCadastro).sendKeys(senha_confirmacao);
	}

	public void preencherPrimeiroNomeCadastro(String primeiro_nome) {
		driver.findElement(txtPrimeiroNomeCadastro).sendKeys(primeiro_nome);
	}

	public void preencherUltimoNomeCadastro(String ultimo_nome) {
		driver.findElement(txtUltimoNomeCadastro).sendKeys(ultimo_nome);
	}

	public void preencherTelefoneCadastro(String telefone) {
		driver.findElement(txtTelefoneCadastro).sendKeys(telefone);
	}

	public void clicarPaisCadastro() {
		driver.findElement(cmbPaisCadastro).click();
	}

	public void clicarOpcPaisCadastro() {
		driver.findElement(opcPaisCadastro).click();
	}

	public void preencherCidadeCadastro(String cidade) {
		driver.findElement(txtCidadeCadastro).sendKeys(cidade);
	}

	public void preencherEnderecoCadastro(String endereco) {
		driver.findElement(txtEnderecoCadastro).sendKeys(endereco);
	}

	public void preencherEstadoCadastro(String estado) {
		driver.findElement(txtEstadoCadastro).sendKeys(estado);
	}

	public void preencherCepCadastro(String cep) {
		driver.findElement(txtCepCadastro).sendKeys(cep);
	}

	public void clicarCheckBox() {
		driver.findElement(chkCorcordo).click();
	}

	public void clicarBotaoRegistrar() {
		driver.findElement(btnRegistrar).click();
	}

	public boolean mensagemAlerta(String menssagem) {
		return menssagem.contentEquals(driver.findElement(txtAlertaCadastro).getText());
	}

	public void clicarConfirmaSenha() {
		driver.findElement(txtConfirmaSenhaCadastro).sendKeys(Keys.TAB);
	}

	public void clicarSenha() {
		driver.findElement(txtSenhaCadastro).sendKeys(Keys.TAB);
	}

	public void clicarNome() {
		driver.findElement(txtNomeCadastro).sendKeys(Keys.TAB);
	}

	public void clicarEmail() {
		driver.findElement(txtEmailCadastro).sendKeys(Keys.TAB);
	}
}
