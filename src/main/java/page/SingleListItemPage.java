package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SingleListItemPage {
	
	WebDriver driver;
	
	public SingleListItemPage(WebDriver driver) {
		this.driver=driver;
	}
	//data for List item
	String item1="mak";
	
	@FindBy(how = How.NAME,using="data") WebElement LIST_ITEM_ELEMENT;
	@FindBy(how = How.NAME,using="todo[0]") WebElement FIRST_LIST_ITEM_BOX_ELEMENT;
	@FindBy(how = How.XPATH,using="/html/body/div[4]/input[2]") WebElement ADD_LIST_ITEM_ELEMENT;
	@FindBy(how = How.XPATH,using="/html/body/div[3]/input[1]") WebElement REMOVE_BUTTON_ELEMENT;
	
	public void addListItem() {
		LIST_ITEM_ELEMENT.sendKeys(item1);
		ADD_LIST_ITEM_ELEMENT.click();
	
	}
	public void checkSingleItemAndRemove() {
		FIRST_LIST_ITEM_BOX_ELEMENT.click();
		REMOVE_BUTTON_ELEMENT.click();
	}
	public void validateSingleItemRemoved() {
		Assert.assertFalse(driver.getPageSource().contains(item1));
		
	}

}
