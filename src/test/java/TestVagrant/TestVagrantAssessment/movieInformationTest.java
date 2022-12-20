package TestVagrant.TestVagrantAssessment;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DriverFactory.WebDriverFactory;

public class movieInformationTest {
		WebDriver driver;
		IMDBPage imdbPage;
		wikiPage wikiPage;
		
		@BeforeTest
		public void setup() {
			driver = WebDriverFactory.getWebDriver("Chrome");
			driver.manage().window().maximize();
			imdbPage = new IMDBPage(driver);
			
		}
		
		@Test(priority = 1)
		public void testIMDB() {
			driver.get("https://www.imdb.com/");
			IMDBPage imdbPage = new IMDBPage(driver);
			imdbPage.searchForMovie()
			.clickMoviePushpaTheRise()
			.fetchMovieReleaseDate()
			.fetchMovieCountryOrigin();
		}
		
		@Test(priority = 2)
		public void testWiki() {
			driver.get("https://en.wikipedia.org/wiki/Main_Page");
			wikiPage wikiPage = new wikiPage(driver);
			wikiPage.searchForMovie()
			.clickMoviePushpaTheRise()
			.fetchMovieReleaseDate()
			.fetchMovieCountryOrigin();
		}
		
		//Method for taking screenshots in case of both passed and failed test cases
		@AfterMethod
		public void tearDown(ITestResult result) throws Exception {
			if (ITestResult.SUCCESS == result.getStatus()) {
				TakesScreenshot sc = (TakesScreenshot) driver;
				File source = sc.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File("./PassedTestsScreenshots/" + result.getName() + ".jpg"));
				System.out.println("Screenshot for Passed Test Cases Taken");
			} 
			else if (ITestResult.FAILURE == result.getStatus()) {
				TakesScreenshot sc = (TakesScreenshot) driver;
				File source = sc.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File("./FailedTestsScreenshots/" + result.getName() + ".jpg"));
				System.out.println("Screenshot for Failed Test Cases Taken");
			}
		}
		
		@AfterTest
		public void closeBrowser() {
			driver.quit();
		}

}
