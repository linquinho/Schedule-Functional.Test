package linkonphol.test.functional;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFunctional {

	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		try {
		
		//Clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//Escrver Descrição
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		//Escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("30/12/2023");
		
		//Clicar em Salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar Mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		
		} finally {
			
			//Fechar o browser
			driver.quit();
		}
			
		
	}


	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		try {
		
		//Clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//Escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("30/12/2023");
		
		//Clicar em Salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar Mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
		
		} finally {
			
			//Fechar o browser
			driver.quit();
		}
			
		
	}


	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		try {
		
		//Clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//Escrver Descrição
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		
		//Clicar em Salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar Mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", message);
		
		} finally {
			
			//Fechar o browser
			driver.quit();
		}
			
		
	}

	@Test
	public void NaoDeveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		try {
		
		//Clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		//Escrver Descrição
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		//Escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("30/12/2010");
		
		//Clicar em Salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar Mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", message);
		
		} finally {
			
			//Fechar o browser
			driver.quit();
		}
			
		
	}
	
}



