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
import pages.HomePage;
import pages.PaginaInicial;
import pages.Login;

public class LoginSteps {

	private static WebDriver driver;
	private PaginaInicial paginaInicial = new PaginaInicial(driver);
	private Login paginaLogin = new Login(driver);
	private HomePage homePage = new HomePage(driver);

	@Before
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\91\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Dado("que acesso a tela de login do usuario")
	public void que_acesso_a_tela_de_login_do_usuario() {
		paginaInicial.carregarPagina();
		assertTrue(paginaInicial.obterTituloDaPagina().endsWith("Shopping"));
		paginaInicial.clicarBotaoSignIn();
	}

	@Quando("submeto o meu login com nome e senha")
	public void submeto_o_meu_login_com_nome_e_senha() {
		paginaLogin.preencherNome("bianca");
		paginaLogin.preencherSenha("Bia123");

		paginaLogin.clicarBotaoEntrar();
	}

	@Entao("devo ser redirecionado home page")
	public void devo_ser_redirecionado_home_page() {
		assertThat(homePage.paginaLogadaSucesso("bianca"), is(true));
	}

	@Quando("submeto o meu login senha")
	public void submeto_o_meu_login_senha() {
		paginaLogin.preencherSenha("Bia123");
	}

	@Entao("devo ver a mensagem de alerta {string}")
	public void devo_ver_a_mensagem_de_alerta(String menssagem) {
		assertThat(paginaLogin.mensagemAlerta(menssagem), is(true));
	}

	@Quando("submeto o meu login nome")
	public void submeto_o_meu_login_nome() {
		paginaLogin.preencherNome("bianca");
		paginaLogin.clicarSenha();
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
