package TestVagrant.TestVagrantAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class IMDBPage {
	private final WebDriver driver;
	
	@FindBy(id = "suggestion-search")
	private WebElement SearchBar;
	
	@FindBy(xpath = "//*[contains(text(),'Pushpa: The Rise - Part 1')]")
	private WebElement SelectMoviePushpaTheRise;
	
	@FindBy(xpath = "//*[contains(text(),'December 17, 2021 (United States)')]")
	private WebElement fetchMovieDate;
	
	@FindBy(xpath = "//a[@href='/search/title/?country_of_origin=IN&ref_=tt_dt_cn']")
	private WebElement fetchCountryOfOrigin;
	
	public IMDBPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}
	
	public IMDBPage searchForMovie() {
		this.SearchBar.sendKeys("Pushpa: The Rise");
		return this;
	}
	
	public IMDBPage clickMoviePushpaTheRise() {
		this.SelectMoviePushpaTheRise.click();
		return this;
	}  
	
	public IMDBPage fetchMovieReleaseDate() {
		String movieDateFromIMDBSource = this.fetchMovieDate.getText();
		String ExpectedTextFromIMDBSource = "December 17, 2021 (United States)";
		Assert.assertEquals(ExpectedTextFromIMDBSource, movieDateFromIMDBSource);
		System.out.println("Release date: "+movieDateFromIMDBSource);
		return this;
	}  
	
	public IMDBPage fetchMovieCountryOrigin() {
		String countryOfOriginFromIMDBSource = this.fetchCountryOfOrigin.getText();
		String ExpectedTextFromIMDBSource = "India";
		Assert.assertEquals(ExpectedTextFromIMDBSource, countryOfOriginFromIMDBSource);
		System.out.println("Country of origin: "+countryOfOriginFromIMDBSource);
		return this;
	}  

}
