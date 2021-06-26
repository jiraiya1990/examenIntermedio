import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyTest {

    public WebDriver driver;
    String URL = "https://www.spotify.com/uy/";

    @Given("Ingresar al sitio de Spotify")
    public void ingresar_al_sitio_de_spotify() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);

    }

    @When("Ingresar a a la seccion premium.")
    public void ingresar_a_a_la_seccion_premium() {
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/uy/premium/']")).click();


    }

    @When("validos que se encuentre los nombres de los planes: individual, premium y familiar")
    public void validos_que_se_encuentre_los_nombres_de_los_planes_individual_premium_y_familiar() {
        List<WebElement> SpotifyPlanes = driver.findElements(By.xpath("//*[@data-current-plan-text='Tu plan actual']"));

        for (WebElement planes : SpotifyPlanes) {
            Assert.assertTrue(planes.getText().contains("Individual"));
            Assert.assertTrue(planes.getText().contains("Premium"));
            Assert.assertTrue(planes.getText().contains("Familiar"));
        }


    }


    @When("Ingresar a la seccion de registro")
    public void ingresar_a_la_seccion_de_registro() {
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/uy/signup/']")).click();

    }

    @When("Completo el campo email con ")
    public void completo_el_campo_email_con() {
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("confirm")).sendKeys("");

    }

    @Then("Se muestra el mensaje Es necesario que introduzcas tu correo electronico")
    public void se_muestra_el_mensaje_es_necesario_que_introduzcas_tu_correo_electronico() {
        WebElement msjError = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(msjError.getText(),"Es necesario que introduzcas tu correo electrónico.");


    }
    @When("Completo el campo email con fff")
    public void completo_el_campo_email_con_fff() {
        driver.findElement(By.id("email")).sendKeys("fff");
        driver.findElement(By.id("confirm")).sendKeys("fff");

    }

    @Then("Se muestra el mensaje Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com")
    public void se_muestra_el_mensaje_este_correo_electrónico_no_es_válido_asegúrate_de_que_tenga_un_formato_como_este_ejemplo_email_com() {
        WebElement msjError = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(msjError.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

    }

    @When("Completo el campo email con test@test.com")
    public void completo_el_campo_email_con_test_test_com() {
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");

    }

    @Then("Se muestra el mensaje Este correo electrónico ya está conectado a una cuenta. Inicia sesión.")
    public void se_muestra_el_mensaje_este_correo_electrónico_ya_está_conectado_a_una_cuenta_inicia_sesión() {
        WebElement msjError = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(msjError.getText(),"Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
    }



    @Given("Me cambio al sitio de Terminos y condiciones {string}")
    public void me_cambio_al_sitio_de_terminos_y_condiciones(String string) {
        driver.get(string);
    }

    @When("Validar que encuentro los link")
    public void validar_que_encuentro_los_link() {
        List<WebElement> links = driver.findElements(By.xpath("//*[@class='container legal-body']/p[2]"));
        Assert.assertNotEquals(links.size(),0);





    }

    @Then("validar que se encuentre {string} , {string} y {string}")
    public void validar_que_se_encuentre_y(String string, String string2, String string3) {
        List<WebElement> links = driver.findElements(By.xpath("//*[@class='container legal-body']/p[2]"));

        for(WebElement li : links){
            Assert.assertTrue(li.getText().contains(string));
            Assert.assertTrue(li.getText().contains(string2));
            Assert.assertTrue(li.getText().contains(string3));

        }
    }

}
