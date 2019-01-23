package ObjectRep;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DuplicateTodopage {

	Repository repository;
	//These are the xpaths for Todo already exists page(http://localhost:8081/todo.php)
	//xpath for the text 'Todo already exists"
	@FindBy(xpath="//html/body/text()")
	WebElement txtTodoExits;
	//xpath for back link
	@FindBy(xpath="//a[contains(text(),'Back')]")
	WebElement backlnk;
	
	
	//These methods are for the page (http://localhost:8081/todo.php) Todo already exists

	public String txtTodoExists()
	{return txtTodoExits.getText();
		}
	public Repository Clickonbacklink()
	{
		backlnk.click();
		return repository;
	}

}
