package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ToggleAllPage {
	
	WebDriver driver;
	public ToggleAllPage(WebDriver driver) {
		this.driver=driver;
		
	}
	//list item data
	String item1="habu";
	String item2="kabu";
	String item3="babu";
	//Define WebElements
	@FindBy(how = How.NAME,using="allbox") WebElement TOGGLEALL_ELEMENT;
	@FindBy(how = How.NAME,using="data") WebElement LIST_ITEM_ELEMENT;
	@FindBy(how = How.NAME,using="todo[0]") WebElement FIRST_LIST_ITEM_BOX_ELEMENT;
	@FindBy(how = How.NAME,using="todo[1]") WebElement SECOND_LIST_ITEM_BOX_ELEMENT;
	@FindBy(how = How.NAME,using="todo[2]") WebElement THIRD_LIST_ITEM_BOX_ELEMENT;
	@FindBy(how = How.XPATH,using="/html/body/div[4]/input[2]") WebElement ADD_LIST_ITEM_ELEMENT;
	@FindBy(how = How.XPATH,using="/html/body/div[3]/input[1]") WebElement REMOVE_BUTTON_ELEMENT;
	public void addListItem() {
		LIST_ITEM_ELEMENT.sendKeys(item1);
		ADD_LIST_ITEM_ELEMENT.click();
		
		LIST_ITEM_ELEMENT.sendKeys(item2);
		ADD_LIST_ITEM_ELEMENT.click();
		LIST_ITEM_ELEMENT.sendKeys(item3);
		ADD_LIST_ITEM_ELEMENT.click();
	}
	public void checkSingleItemAndRemove() {
		FIRST_LIST_ITEM_BOX_ELEMENT.click();
		REMOVE_BUTTON_ELEMENT.click();
	}
	public void validateListItemChecked() {
		if(TOGGLEALL_ELEMENT.isSelected()) {
			Assert.assertTrue(FIRST_LIST_ITEM_BOX_ELEMENT.isSelected());
			Assert.assertTrue(SECOND_LIST_ITEM_BOX_ELEMENT.isSelected());
			Assert.assertTrue(THIRD_LIST_ITEM_BOX_ELEMENT.isSelected());
		}
		
	}
	public void validateSingleItemRemoved() {
		Assert.assertFalse(driver.getPageSource().contains(item1));
		
	}
	public void validateRemoveAll() {
		Assert.assertFalse(driver.getPageSource().contains(item2));
		Assert.assertFalse(driver.getPageSource().contains(item3));
		
	}
	
	public void clickToggleAll() {
		TOGGLEALL_ELEMENT.click();
	}
	public void removeAll() {
		REMOVE_BUTTON_ELEMENT.click();
	}

}
