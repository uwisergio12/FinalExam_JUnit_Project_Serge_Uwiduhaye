package test;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.ListItemPage;
import util.BrowserFactory;

public class AllTests {
	
	WebDriver driver;
	
	String ListItem ="Sergio";
	
//	Test 1: Validate when the toggle all check box is CHECKED, all check boxes for list items are also CHECKED ON.
	
	@Test
	public void validUserShouldBeAbbleToCheckToggleAllCheckBox() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		ListItemPage listItempage = PageFactory.initElements(driver,ListItemPage.class);
		
		listItempage.addListItem(ListItem);
		listItempage.clickAddButton();
		
		listItempage.addListItem(ListItem);
		listItempage.clickAddButton();
		
		listItempage.addListItem(ListItem);
		listItempage.clickAddButton();
		
		listItempage.checkToggleAllCheckbox();
		Thread.sleep(3000);
		
		
		System.out.println(listItempage.getCheckBoxCount());
		
		listItempage.isCheckedIn();
		BrowserFactory.teardown();
		
	}
	
//	Test 2: Validate that a single list item could be removed using the remove button when a single checkbox is selected.

	@Test
	public void validUserShouldBeAbleToRemoveASingleListItem() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		ListItemPage listItempage = PageFactory.initElements(driver,ListItemPage.class);
		
		listItempage.addListItem(ListItem);
		listItempage.clickAddButton();
		listItempage.checkSingleItemCheckBox();
		
		String checkItemText = listItempage.getCheckSingleItemCheckBox();
		System.out.println(checkItemText);
		System.out.println("====================");
		
		listItempage.clickRemoveButton();
		Thread.sleep(3000);
		
		//go throught all my list items and check if that "checkItemText" exist -- if not good.
		listItempage.checkFirstCheckBoxTextExist(checkItemText);
		
		
		BrowserFactory.teardown();	
		
	}
	
//	Test 3: Validate that all list item could be removed using the remove button and when "Toggle All" functionality is on.

	@Test
	public void validUserShouldBeAbleToRemoveAllListItems() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		ListItemPage listItempage = PageFactory.initElements(driver,ListItemPage.class);
		
		listItempage.addListItem(ListItem);
		listItempage.clickAddButton();
		
		listItempage.addListItem(ListItem);
		listItempage.clickAddButton();
		
		listItempage.addListItem(ListItem);
		listItempage.clickAddButton();
		
		listItempage.checkToggleAllCheckbox();
		listItempage.clickRemoveButton();
		Thread.sleep(3000);
		
		assert listItempage.getCheckBoxCount()==1;
		
		BrowserFactory.teardown();	
		
	}
}