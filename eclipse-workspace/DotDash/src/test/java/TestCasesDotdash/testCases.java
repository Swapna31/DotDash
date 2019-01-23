package TestCasesDotdash;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import ObjectRep.DuplicateTodopage;
import ObjectRep.Repository;
import TestBase.TestBase;




public class testCases extends TestBase {
	Repository repository;
	DuplicateTodopage duplicatetodopg;
	
	
	@BeforeMethod
	public void binitialisation()
	{
		SetUp();
		repository=PageFactory.initElements(driver,Repository.class);
	}
	
	
	//This testcase will validate whether the Newly added Todo exists in the list.
	
	@Test(priority=0,dataProvider="Tododetails")
	public void AddTodoTestcase01(String TodoName,String Category,String dueday,String duemonth,String dueyear,String xpathStr,String ExpectedTodoname)
	{
		try 
		{
		repository=PageFactory.initElements(driver,Repository.class);
		repository.InputTxtinToadname(TodoName);
		repository.SelCategory(Category);
		repository.Seldueday(dueday);
		repository.SeldueMonth(duemonth);
		repository.Seldueyear(dueyear);
		repository.ClickOnAddbtn();
		String actualvalue=repository.CaptureTodoName(xpathStr);
		Assert.assertEquals(ExpectedTodoname, actualvalue );
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	
	@DataProvider(name="Tododetails")
	public Object[][] getTodoDetails()
	{
		 return new Object[][]  { { "DotdashTesttodo1", "2","10","3","2020","DotdashTesttodo1","DotdashTesttodo1"}, { "DotdashTesttodo2", "3","11","4","2020","DotdashTesttodo2","DotdashTesttodo2"}};
	}
	
	//Test verifies adding duplicate todo redirecting to proper page or not
	
	@Test(priority=1)
	@Parameters ({ "ExistingTodoname" })
	public void DuplicateAddTodo(String ExistingTodoname)
	{
		duplicatetodopg=PageFactory.initElements(driver,DuplicateTodopage.class);
		repository=PageFactory.initElements(driver,Repository.class);
		repository.InputTxtinToadname(ExistingTodoname);
		repository.ClickOnAddbtn();
		//String handle=driver.getWindowHandle();
		//driver.switchTo().window(handle);
		String msg=driver.getCurrentUrl();
		Assert.assertEquals("http://localhost:8081/todo.php",msg);
		
	}
	
	//This test verifies whether the selected Todo is getting deleted or not
	@Test(priority=2)	
	public void DeleteTodo()
	{
	repository=PageFactory.initElements(driver,Repository.class);
	repository.CheckChkBoxTodo("DotdashTesttodo1");
	repository.ClickOnRemoveBtn();
	}
	
	@AfterMethod
	public void ClosetheApplication()
	{
		TearDown();
	}
}
