package StepDefinition;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import POM.giftcard_page;
import POM.home_page;
import POM.search_result_page;
import Utilities.excel_utility;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LivingSubmenu {
	
public WebDriver driver = BaseClass.getDriver();
	
	Logger logger=BaseClass.getlogger1();
	public home_page homepage = new home_page(driver);
	public  search_result_page search_result = new search_result_page(driver);;
	giftcard_page  gift_carrd;
	//public WebDriver driver;
	public excel_utility excel= new excel_utility("C:\\Users\\2303778\\eclipse-workspace\\Hackathon_Project-1\\src\\test\\java\\Utilities\\Input (1).xlsx");

	
	
	@Given("user is on urbanladder")
	public void user_is_on_urbanladder() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("Hover mouse to living")
	public void hover_mouse_to_living() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 homepage.Hover();
	}

	@Then("sub menus should be appeared and print it")
	public void sub_menus_should_be_appeared_and_print_it() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		List<WebElement> submenu = homepage.Living_Options();
		 int menu_count=0;
		 for(int i=0;i<submenu.size();i++) {
		 String sub_menu = submenu.get(i).getText();
		 excel.setCellData("Sheet3", menu_count, 0 ,sub_menu);
		 menu_count++;
		 
		 }
	}
}
