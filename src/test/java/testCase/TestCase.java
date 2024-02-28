package testCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//import java.io.IOException;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.base;

import POM.*;
//import io.github.bonigarcia.wdm.WebDriverManager;
import Utilities.excel_utility;

public class TestCase extends base{
	
	public home_page homepage;
	public  search_result_page search_result;
	giftcard_page  gift_carrd;
	public excel_utility excel= new excel_utility("C:\\Users\\2303778\\eclipse-workspace\\Hackathon_Project-1\\src\\test\\java\\Utilities\\Input (1).xlsx");



	@Test(priority=0)
	public void search_functionality() throws FileNotFoundException, IOException {
		//base.getlogger().info("Checking search functionality");
		homepage= new home_page(driver);
		homepage.searchbox();
		String input=excel.getCellData("Sheet1",0,1);
		homepage.searchbox().sendKeys(input);
		homepage.clicksearchbtn();
		
		search_result = new search_result_page(driver);
		
		search_result.close_popup();
		boolean result = search_result.header_check();
		Assert.assertTrue(result);
		
		screenShot("Search");
		
		
	}
	
	@Test(priority=1)
	public void filter_functionality() throws InterruptedException, FileNotFoundException, IOException {
		//base.getlogger().info("Checking filter functionality");
		search_result.category_hover(); 
		search_result.kids_filters();
		search_result.instock_filters();
		String result=search_result.first_result();
		Assert.assertTrue(result.contains(excel.getCellData("Sheet1",1,1)));
		
	    screenShot("filter");
		
	
	//	search_result.check_filter();
		
	}
	
	
	@Test(priority=2)
	public void check_sortfuction() throws IOException {
		
		
		//path=base.screenShot("S", driver);
		//base.getlogger().info("Checking sort functionality");
		search_result.sort();
		
		List<WebElement> prices=search_result.prices();
		for(int i=1;i<5;i++) {
			
			String price=prices.get(i).getAttribute("content");
			String nprice=prices.get(i).getAttribute("content");
			int  pricee= Integer.parseInt(price);
			int  nextprice = Integer.parseInt(nprice);
			Assert.assertTrue(nextprice<=pricee);
			
			
			
			
		}
		screenShot("check");
		
	}
	
	
	@Test(priority=3)
	public void check_and_print() throws FileNotFoundException, IOException {
		//base.getlogger().info("Checking check and print");
		List<WebElement> Details = search_result.check_print_results();
		int r=1;
		for(int i=0;i<3;i++) {
			String detail = Details.get(i).getText();
			Assert.assertTrue(detail.contains(excel.getCellData("Sheet1",1,1)));
			excel.setCellData("Sheet2", r ,0, detail);
			r++;
			System.out.println(detail);
			
			
		}
		screenShot("print");
		
		
		
		
		}
	 @Test(priority=4)
	 public void submenu_printcheck() throws InterruptedException, IOException {
		// base.getlogger().info("Checking submenu options");
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