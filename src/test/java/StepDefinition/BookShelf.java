package StepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.giftcard_page;
import POM.home_page;
import POM.search_result_page;
import Utilities.excel_utility;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class BookShelf extends BaseClass {
	public WebDriver driver = BaseClass.getDriver();
	
	Logger logger=BaseClass.getlogger1();
	public home_page homepage = new home_page(driver);
	public  search_result_page search_result = new search_result_page(driver);;
	giftcard_page  gift_carrd;
	//public WebDriver driver;
	public excel_utility excel= new excel_utility("C:\\Users\\2303778\\eclipse-workspace\\Hackathon_Project-1\\src\\test\\java\\Utilities\\Input (1).xlsx");

@Given("User navigated to urbanladder")
public void user_navigated_to_urbanladder() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
    
    
}

@When("search for bookselves")
public void search_for_bookselves_under() throws FileNotFoundException, IOException {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
    
    homepage= new home_page(driver);
	homepage.searchbox();
	String input=excel.getCellData("Sheet1",0,1);
	homepage.searchbox().sendKeys(input);
	homepage.clicksearchbtn();
	search_result = new search_result_page(driver);
	
	search_result.close_popup();
    
    
}

@When("select kids category")
public void select_kids_category() throws InterruptedException {
	
	search_result.category_hover(); 
	search_result.kids_filters();
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
}

@When("select in stock")
public void select_in_stock() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	search_result.instock_filters();
}

@When("priority low to high")
public void priority_low_to_high() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	search_result.sort();
}

@Then("Print the first three bookshelves")
public void print_the_first_three_bookshelves_under() throws IOException {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	List<WebElement> Details = search_result.check_print_results();
	int r=1;
	for(int i=0;i<3;i++) {
		String detail = Details.get(i).getText();
		Assert.assertTrue(detail.contains(excel.getCellData("Sheet1",1,1)));
		excel.setCellData("Sheet2", r ,0, detail);
		r++;
		System.out.println(detail);
		
		
	}
}
}







