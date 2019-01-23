package ObjectRep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import TestBase.TestBase;

public class Repository extends TestBase {
	//These are xpaths for home page
	//locator for Todoname textbox
	@FindBy(xpath="//input[@name='data']")
	WebElement Tdtxtbox;
	//locator for Category dorpdown
	@FindBy(name="category")
	WebElement Categorydropdown;
	//locator for Due day drop down
	@FindBy(name="due_day")
	WebElement duedatedropdown;
	//locator for due month
	@FindBy(name="due_month")
	WebElement duemonthdropdown;
	//locator for due year
	@FindBy(name="due_year")
	WebElement dueyeardropdown;
	//locator for add button
	@FindBy(xpath="//input[@value='Add']")
	WebElement AddBtn;
	//locator for Todo name
	@FindBy(xpath="//span[contains(text(),'Test todo')]")
	WebElement TodoName;
	//Locator for addcategory button
	@FindBy(xpath="//input[@value='Add category']")
	WebElement AddCategorybtn;
	//Locator for Todo checkbox
	@FindBy(xpath="//input[@name='todo[13]']")
	WebElement Todocheckbox;
	//Locator for Remove button
	@FindBy(xpath="//input[@value='Remove']")
	WebElement Removebtn;
	//Locator for Todo number
	//TodoNumbersXpath(1,2,3....etc)
	@FindBy(xpath="//a[contains(text(),'13')]")
	WebElement TodoNumberxpath;
	@FindBy(xpath="//span[contains(text(),'Test todo')]/preceding-sibling::input")
	WebElement TodoChkbox;
	//span[contains(text(),'Test todo')]/preceding-sibling::input

//Method for input todoname in text box
public void InputTxtinToadname(String Toadname)
{
	Tdtxtbox.clear();
	Tdtxtbox.sendKeys(Toadname);
}
//method for Clickin on Add button
public void ClickOnAddbtn()
{
	AddBtn.click();
}
//Method for selecting category from drop down
public void SelCategory(String categoryindex)
{
	Select category=new Select(Categorydropdown);
	category.selectByValue(categoryindex);
}
//Method for selecting due date
public void Seldueday(String day)
{
	Select duedaydpdn=new Select(duedatedropdown);
	duedaydpdn.selectByValue(day);
}
//Method for selecting due month
public void SeldueMonth(String monthindex)
{
	Select duemonthdpdn=new Select(duemonthdropdown);
	duemonthdpdn.selectByValue(monthindex);
}
//method for Selecting due year
public void Seldueyear(String year)
{
	Select dueyeardpdn=new Select(dueyeardropdown);
	dueyeardpdn.selectByValue(year);
}
//method for Caprturing Todo name
public String CaptureTodoName(String Expectedtodoname)
{
	String xpath = "//span[contains(text(),'";
	String afterxpath = "')]";
	WebElement xpathofAddedTodoname=	driver.findElement(By.xpath(xpath+Expectedtodoname+afterxpath));
	return xpathofAddedTodoname.getText();
}
//method for Clicking on AddCategory button
public void ClickOnAddCatogerybtn()
{
	AddCategorybtn.click();
}
//Method for selecting checkbox for given Todonumber
public void selectTodoCheckbox(int TodoNumber)
{
	for(int i=TodoNumber;i<14;i++)
	{
	String afterpath="]']";
	String beforexpath ="//input[@name='todo[";
	
	WebElement TodoNumberTobeselected=driver.findElement(By.xpath(beforexpath+i+afterpath));
	TodoNumberTobeselected.click();
	
	}
}
//Method for clicking on Remove button
public void ClickOnRemoveBtn()
{	
	Removebtn.click();
	
}

public boolean VerifyTodoNumberExists()
{return TodoNumberxpath.isDisplayed();
}

public void CheckChkBoxTodo(String TodonameTodelete)
{
	//span[contains(text(),'Test todo')]/preceding-sibling::input
	String beforepath="//span[contains(text(),'";
	String afterpath="')]/preceding-sibling::input";
	driver.findElement(By.xpath(beforepath+TodonameTodelete+afterpath)).click();
}
}
