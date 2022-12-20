package TestVagrant.TestVagrantAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class wikiPage {
private final WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Search Wikipedia']")
	private WebElement SearchWikipedia;
	
	@FindBy(xpath = "//span[contains(.,'Pushpa: The Rise')]")
	private WebElement SelectMoviePushpaTheRise;
	
	@FindBy(xpath = "//li[contains(.,'17 December 2021 (2021-12-17)')]")
	private WebElement fetchMovieDate;
	
	@FindBy(xpath = "(//td[contains(.,'India')])[2]")
	private WebElement fetchCountryOfOrigin;
	
	public wikiPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}
	
	public wikiPage searchForMovie() {
		this.SearchWikipedia.sendKeys("Pushpa: The Rise");
		return this;
	}
	
	public wikiPage clickMoviePushpaTheRise() {
		this.SelectMoviePushpaTheRise.click();
		return this;
	}  
	
	public wikiPage fetchMovieReleaseDate() {
		String movieDateFromWikiSource = this.fetchMovieDate.getText();
		String ExpectedTextFromWikiSource = "17 December 2021";
		Assert.assertEquals(ExpectedTextFromWikiSource, movieDateFromWikiSource);
		System.out.println("Release date: "+movieDateFromWikiSource);
		return this;
	} 
	
	public wikiPage fetchMovieCountryOrigin() {
		String countryOfOriginFromWikiSource = this.fetchCountryOfOrigin.getText();
		String ExpectedTextFromWikiSource = "India";
		Assert.assertEquals(ExpectedTextFromWikiSource, countryOfOriginFromWikiSource);
		System.out.println("Country of origin: "+countryOfOriginFromWikiSource);
		return this;
	}  

}
