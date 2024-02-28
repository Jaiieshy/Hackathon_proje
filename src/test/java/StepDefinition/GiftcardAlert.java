package StepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import POM.giftcard_page;
import POM.home_page;
import POM.search_result_page;
import Utilities.excel_utility;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GiftcardAlert extends BaseClass{

	
	
public WebDriver driver = BaseClass.getDriver();
	
	Logger logger=BaseClass.getlogger1();
	public home_page homepage = new home_page(driver);
	public  search_result_page search_result = new search_result_page(driver);;
	giftcard_page  gift_carrd;
	//public WebDriver driver;
	public excel_utility excel= new excel_utility("C:\\Users\\2303778\\eclipse-workspace\\Hackathon_Project-1\\src\\test\\java\\Utilities\\Input (1).xlsx");


	
		
		@Given("on urbanladder Home page")
		public void on_urbanladder_home_page() {
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
		}

		@When("click on gift card")
		public void click_on_gift_card() throws InterruptedException, FileNotFoundException, IOException {
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
			gift_carrd= new giftcard_page(driver);
			gift_carrd.homeButtonGiftCard_click().click();
		 	String search =excel.getCellData("Sheet1", 2, 1);
		 	gift_carrd. homeButtonGiftCard_click().sendKeys(search);
		 	gift_carrd.search_btn().click();
		 	
		}

		@When("click on type of giftcard")
		public void click_on_type_of_giftcard() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			gift_carrd.gift();
		}

		@When("put valid price add click next")
		public void put_valid_price_add_click_next() throws FileNotFoundException, IOException {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			String amt = excel.getCellData("Sheet4", 0, 1);
		     gift_carrd.searchbox_amt().sendKeys(amt);
		 	
		 	gift_carrd.nxt_button();
		}

		@When("enter valid details and wrong email")
		public void enter_valid_details_and_wrong_email() throws FileNotFoundException, IOException, InterruptedException {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			
			String rname = excel.getCellData("Sheet4", 1, 1);
		 	gift_carrd.Name_receiver().sendKeys(rname);
		 	
		 	String remail = excel.getCellData("Sheet4", 2, 1);   
		 	gift_carrd.receiver_Email().sendKeys(remail);
		 	
		 	String rnumber = excel.getCellData("Sheet4", 3, 1);
		 	gift_carrd.receiver_Number().sendKeys(rnumber);
		 	
		 	String sname = excel.getCellData("Sheet4", 4, 1);
		 	gift_carrd.Name_sender().sendKeys(sname);
		 	
		 	Thread.sleep(5000);
		 	
		 	String semail = excel.getCellData("Sheet4", 5, 1);
		 	gift_carrd.sender_Email().sendKeys(semail);
		 	
		 	String saddress = excel.getCellData("Sheet4", 6, 1);
		 	gift_carrd.Sender_Address().sendKeys(saddress);
		 	Thread.sleep(5000);
		 	
		 	
		 	
		 	
		 	String pincode = excel.getCellData("Sheet4", 7, 1);
		 	gift_carrd.Sender_pincode().sendKeys(pincode);
		 	
		 	String snumber = excel.getCellData("Sheet4", 8, 1);
		 	
		 	gift_carrd.Sender_Number().sendKeys(snumber);
		 	//gift_card.Message();
		 	
		 		String message=excel.getCellData("Sheet4", 9, 1);
		 		gift_carrd.Send_message().sendKeys(message);
		 	
		}

		@Then("alert should appear")
		public void alert_should_appear() throws InterruptedException, IOException {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			gift_carrd.Confirm_button();
		 	Thread.sleep(3000);
		 	String AlertMessage= gift_carrd.AlertMessage();
		 	System.out.println(AlertMessage);
		 	excel.setCellData("Sheet3", 8, 0, AlertMessage);
		 	
		}
		@Then("put the valid Details")
		public void put_the_valid_details() throws FileNotFoundException, IOException {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			
			 String rremail = excel.getCellData("Sheet4", 10, 1);
			 gift_carrd.receiver_Email().clear();
			 gift_carrd.receiver_Email().sendKeys(rremail);
			 gift_carrd.Confirm_button().click();
		}

		@Then("checkout the page should be validated")
		public void checkout_the_page_should_be_validated() throws FileNotFoundException, IOException {
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
			 String examt = excel.getCellData("Sheet5", 0, 0);
			 String acamount=gift_carrd.cnfrm_amt_validation().getText();
			 Assert.assertEquals(acamount, examt);
			 
			 String exReceiverName = excel.getCellData("Sheet5", 1, 0);
			 String acReceiverName=gift_carrd.cnfrm_rname_validation().getText();
			 Assert.assertEquals(exReceiverName, acReceiverName);
			 
			 String exSendererEmail = excel.getCellData("Sheet5", 2, 0);
			 String acSendererEmail=gift_carrd.cnfrm_semail_validation().getText();
			 Assert.assertEquals(exSendererEmail, acSendererEmail);
			 
			 String exMessage = excel.getCellData("Sheet5", 3, 0);
			 String acMessage=gift_carrd.cnfrm_message_validation().getText();
			 Assert.assertEquals(exMessage, acMessage);
		}

	}

