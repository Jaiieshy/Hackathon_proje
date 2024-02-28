package testCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.base;
import POM.giftcard_page;
import POM.home_page;
import POM.search_result_page;
import Utilities.excel_utility;

public class TestCase3 extends base {
	
	
	
	
	public home_page homepage;
	public  search_result_page search_result;
	giftcard_page  gift_carrd;
	public excel_utility excel= new excel_utility("C:\\Users\\2303778\\eclipse-workspace\\Hackathon_Project-1\\src\\test\\java\\Utilities\\Input (1).xlsx");
	
	
	 @Test(priority=0)
	public void choose_giftcard_validate() throws FileNotFoundException, IOException, InterruptedException{
		// base.getlogger().info("Giftcard Validation");
		 gift_carrd= new giftcard_page(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	gift_carrd.homeButtonGiftCard_click().click();
	String search =excel.getCellData("Sheet1", 2, 1);
	gift_carrd. homeButtonGiftCard_click().sendKeys(search);
	gift_carrd.search_btn().click();
	
	gift_carrd.gift();
	
	
    String amt = excel.getCellData("Sheet4", 0, 1);
    gift_carrd.searchbox_amt().sendKeys(amt);
	
	gift_carrd.nxt_button();
	
	String rname = excel.getCellData("Sheet4", 1, 1);
	gift_carrd.Name_receiver().sendKeys(rname);
	
	String remail = excel.getCellData("Sheet4", 2, 1);   
	gift_carrd.receiver_Email().sendKeys(remail);
	
	String rnumber = excel.getCellData("Sheet4", 3, 1);
	gift_carrd.receiver_Number().sendKeys(rnumber);
	
	String sname = excel.getCellData("Sheet4", 4, 1);
	gift_carrd.Name_sender().sendKeys(sname);
	
	Thread.sleep(2000);
	
	String semail = excel.getCellData("Sheet4", 5, 1);
	gift_carrd.sender_Email().sendKeys(semail);
	
	String saddress = excel.getCellData("Sheet4", 6, 1);
	gift_carrd.Sender_Address().sendKeys(saddress);
	Thread.sleep(2000);
	
	
	
	
	String pincode = excel.getCellData("Sheet4", 7, 1);
	gift_carrd.Sender_pincode().sendKeys(pincode);
	
	String snumber = excel.getCellData("Sheet4", 8, 1);
	
	gift_carrd.Sender_Number().sendKeys(snumber);
	//gift_card.Message();
	
		String message=excel.getCellData("Sheet4", 9, 1);
		gift_carrd.Send_message().sendKeys(message);
	

	gift_carrd.Confirm_button().click();
	Thread.sleep(3000);
	
	String AlertMessage= gift_carrd.AlertMessage();
	System.out.println(AlertMessage);
	excel.setCellData("Sheet3", 8, 0, AlertMessage);
	
	
	
	screenShot("giftcard");
	
	 }
	 @Test(priority=1)
	public void checkout_validation() throws FileNotFoundException, IOException {
		// base.getlogger().info("checkout validation");
		 String rremail = excel.getCellData("Sheet4", 10, 1);
		 gift_carrd.receiver_Email().clear();
		 gift_carrd.receiver_Email().sendKeys(rremail);
		 
		 gift_carrd.Confirm_button().click();
		 
		 
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
		 
		 screenShot("out");
		 
		 
	 }

}
