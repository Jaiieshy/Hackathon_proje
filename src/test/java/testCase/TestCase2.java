package testCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.base;
import POM.giftcard_page;
import POM.home_page;
import POM.search_result_page;
import Utilities.excel_utility;

public class TestCase2 extends base {
	
	
	public home_page homepage;
	public  search_result_page search_result;
	giftcard_page  gift_carrd;
	public excel_utility excel= new excel_utility("C:\\Users\\2303778\\eclipse-workspace\\Hackathon_Project-1\\src\\test\\java\\Utilities\\Input (1).xlsx");
	
	
	
	
	 @Test(priority=0)
	 public void submenu_printcheck() throws InterruptedException, IOException {
		 
			
		// base.getlogger().info("Checking submenu options");
		 search_result = new search_result_page(driver);
		 search_result.scroll_down();
		 search_result.nhome_page();
		 homepage = new home_page(driver);
		 
		 homepage.Hover();
		 List<WebElement> submenu = homepage.Living_Options();
		 int menu_count=0;
		 for(int i=0;i<submenu.size();i++) {
		 String sub_menu = submenu.get(i).getText();
		 excel.setCellData("Sheet3", menu_count, 0 ,sub_menu);
		 menu_count++;
		 
		 }
		 Assert.assertEquals(9, menu_count);
		 
		 
		 screenShot("Submenu");
		 
		 
	 }

}
