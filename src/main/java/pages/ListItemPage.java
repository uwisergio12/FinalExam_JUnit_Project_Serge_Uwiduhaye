package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;


public class ListItemPage extends BasePage {
	
WebDriver driver;

	public ListItemPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "input[name='allbox']") WebElement Toggle_All_CheckBox_Element;
	@FindBy(how = How.CSS, using = "input[value='Remove']") WebElement Remove_Button_Element;
	@FindBy(how = How.CSS, using = "input[name='data']") WebElement Add_ListItem_Element;
	@FindBy(how = How.CSS, using = "input[value='Add']") WebElement Add_Button_Element;
	@FindBy(how = How.CSS, using = "#todos-content > form > ul > li:nth-child(1) > input[type=checkbox]") WebElement Single_Item_CheckBox_Element;
	@FindBy(how = How.CSS, using = "#todos-content > form > ul > li:nth-child(1)") WebElement First_CheckBox_Element;
	
	
	@FindBy(how = How.CSS, using = "input[type='checkbox']") public List<WebElement> chkBox;
	
	@FindBy(how = How.CSS, using = "#todos-content > form > ul") public List<WebElement> chkBoxAllItems;
	
	String enteredListItem;
	
	public void isCheckedIn() {
		for(WebElement item : chkBox) {
			assert item.isSelected();
		}
	}
	
	public int getCheckBoxCount() {
		return chkBox.size();
	}
	
	
	public void addListItem(String ListItem) throws InterruptedException {
		enteredListItem = ListItem + generateRandomNum(999);
		Add_ListItem_Element.sendKeys(enteredListItem);
		Thread.sleep(3000);
	
	}
	
	public void clickAddButton() {
		Add_Button_Element.click();
	}
	
	public void checkSingleItemCheckBox() {
		Single_Item_CheckBox_Element.click();
		assert Single_Item_CheckBox_Element.isSelected();
	}
	
	public String getCheckSingleItemCheckBox() {
		return First_CheckBox_Element.getText();
	}
	
	public void checkFirstCheckBoxTextExist(String checkboxName) {
		for(WebElement item : chkBoxAllItems) {
			
			System.out.println(item.getText());
			
			if(!checkboxName.equals(item.getText())) {
				System.out.println("good, not found");
			}
			else {
				System.out.println("bad, found");
			}
			
		}
	}
	
	public void checkToggleAllCheckbox() {
		Toggle_All_CheckBox_Element.click();
		assert Toggle_All_CheckBox_Element.isSelected();
		System.out.println("toggle all check box is CHECKED, all check boxes for list items are also CHECKED ON!!");
		
	}
	
	public void clickRemoveButton() {
		Remove_Button_Element.click();
		
		
	}
}
