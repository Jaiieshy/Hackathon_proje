package POM;


import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
import Base.base;
 
 
public class search_result_page extends base{


 
	public WebDriver driver;
	public search_result_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]")
	 WebElement filters;

	 @FindBy(xpath = "//*[@id=\"filters_primary_category_Kids_Bookshelves\"]")
	 WebElement category_kids;
	 @FindBy(xpath ="//*[@id='filters_availability_In_Stock_Only']")
	 WebElement filters_instock;
	 @FindBy(xpath = "//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span")
	 WebElement search_sortby;
	 @FindBy(xpath = "//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[3]")
	 WebElement sortby_high_low;
	 @FindBy(xpath = "//*[@id='search-results']/div[3]/ul/li")
	 List<WebElement> print_results;
	 @FindBy(xpath="//*[@id=\"search-results\"]/div[1]/h2")
	 WebElement header;
	 @FindBy(xpath = "//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")
	WebElement authentiaction_popup;
	 @FindBy(xpath = "//*[@id=\"search-results\"]/div[3]/ul/li[1]/div/div[5]/a")
	WebElement lresult;
	 @FindBy(xpath ="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]" )
		WebElement mousehover;
	 @FindBy(xpath ="/html/body/div[1]/div[1]/div[2]/div[1]/div[3]/ul/li/div/div[5]/a/div[2]/meta[1]" )
	 List<WebElement> prices;
	 @FindBy(xpath ="//*[@id=\"header\"]/div[1]/div/section[1]/a/figure" )
	 WebElement logo;
	//action
	//Actions a = new Actions(driver);
	public void kids_filters() throws InterruptedException {
		category_kids.click();
		Thread.sleep(2000);
	
	}
	public void instock_filters() throws InterruptedException {
		
		filters_instock.click();
		Thread.sleep(2000);
	}
	public void sort() {
		WebElement recommended = (search_sortby);
		Actions a = new Actions(driver);
		a.moveToElement(recommended).perform();
		(sortby_high_low ).click();
		}
	public List<WebElement> check_print_results() {
		List<WebElement> details = print_results;
		return details;

	}
	
	public boolean header_check() {
		boolean a = header.isDisplayed();
		return a;
	}
	public void close_popup() {
		authentiaction_popup.click();
		}
	
	public String first_result() {
		String lstdetails =lresult.getText();
		return lstdetails;
	}
	public void category_hover() {
		//
		
		mousehover.click();
	}
	public List<WebElement> prices(){
		return prices ;
	}
	public void nhome_page() {
		logo.click();
	}
	public void scroll_down() {
		Actions a= new Actions(driver);
		a.keyDown(Keys.PAGE_UP).perform();
	}
	
}
