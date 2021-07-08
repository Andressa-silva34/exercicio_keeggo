package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CriarCadastro;
import pages.HomePage;
import pages.Login;
import pages.PaginaInicial;

public class CadastroSteps {

	private static WebDriver driver;
	private PaginaInicial paginaInicial = new PaginaInicial(driver);
	private Login paginaLogin = new Login(driver);
	private CriarCadastro paginaCadastro = new CriarCadastro(driver);
	private HomePage homePage = new HomePage(driver);

	@Before
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\91\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Dado("que acesso a tela de cadastro")
	public void que_acesso_a_tela_de_cadastro() {
		paginaInicial.carregarPagina();
		assertTrue(paginaInicial.obterTituloDaPagina().endsWith("Shopping"));
		paginaInicial.clicarBotaoSignIn();
		paginaLogin.clicarCadastro();
		

	}

	@Quando("submeto o meu cadastro com nome: {string}, email: {string}, senha: {string} e senha de confirmacao: {string}")
	public void submeto_o_meu_cadastro_com_nome_email_senha_e_senha_de_confirmacao(String nome, String email,
			String senha, String senha_confirmacao) {

		paginaCadastro.preencherNome(nome);
		paginaCadastro.preencherEmail(email);
		paginaCadastro.preencherSenha(senha);
		paginaCadastro.preencherConfirmaSenha(senha_confirmacao);

		paginaCadastro.clicarCheckBox();

		paginaCadastro.clicarBotaoRegistrar();

	}

	@Entao("devo ser redirecionado pagina incial")
	public void devo_ser_redirecionado_pagina_incial() {
		assertThat(homePage.paginaLogadaSucesso("andressa"), is(true));
	}

	@Quando("submeto o meu cadastro com email: {string}, senha: {string} e senha de confirmacao: {string}")
	public void submeto_o_meu_cadastro_com_email_senha_e_senha_de_confirmacao(String email, String senha,
			String senha_confirmacao) {
		paginaCadastro.clicarNome();
		paginaCadastro.preencherEmail(email);
		paginaCadastro.preencherSenha(senha);
		paginaCadastro.preencherConfirmaSenha(senha_confirmacao);

	}

	@Quando("submeto o meu cadastro com nome: {string}, senha: {string} e senha de confirmacao: {string}")
	public void submeto_o_meu_cadastro_com_nome_senha_e_senha_de_confirmacao(String nome, String senha,
			String senha_confirmacao) {

		paginaCadastro.preencherNome(nome);
		paginaCadastro.clicarEmail();
		paginaCadastro.preencherSenha(senha);
		paginaCadastro.preencherConfirmaSenha(senha_confirmacao);

	}

	@Quando("submeto o meu cadastro com nome: {string} e email: {string}")
	public void submeto_o_meu_cadastro_com_nome_e_email(String nome, String email) {

		paginaCadastro.preencherNome(nome);
		paginaCadastro.preencherEmail(email);
		paginaCadastro.clicarSenha();
		paginaCadastro.clicarConfirmaSenha();

	}

	@Quando("submeto o meu cadastro com submeto o meu cadastro com nome: {string}, email: {string}, senha: {string} e senha de confirmacao: {string}")
	public void submeto_o_meu_cadastro_com_submeto_o_meu_cadastro_com_nome_email_senha_e_senha_de_confirmacao(
			String nome, String email, String senha, String senha_confirmacao) {

		paginaCadastro.preencherNome(nome);
		paginaCadastro.preencherEmail(email);
		paginaCadastro.preencherSenha(senha);
		paginaCadastro.preencherConfirmaSenha(senha_confirmacao);

		paginaCadastro.clicarConfirmaSenha();

	}

	@Entao("devo ver a mensagem {string}")
	public void devo_ver_a_mensagem(String mensagem_saida) {

		assertThat(paginaCadastro.mensagemAlerta(mensagem_saida), is(true));
	}

	@After(order = 1)
	public void capturaTela(Scenario scenario) {
		TakesScreenshot camera = (TakesScreenshot) driver;
		File capturaDeTela = camera.getScreenshotAs(OutputType.FILE);

		String nomeArquivo = "resources/screenshots/" + scenario.getName() + "_" + scenario.getStatus() + ".png";
		System.out.println(nomeArquivo);
		try {
			Files.move(capturaDeTela, new File(nomeArquivo));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@After(order = 0)
	public static void fecharPagina() {
		driver.quit();
	}
}
