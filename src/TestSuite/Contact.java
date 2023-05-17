package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Initialization;
import Common.Utilities;
import CommonScreen.ContactScreen;


public class Contact extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = ContactScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
		Utilities.refreshScreen(driver);
	}
		
	@Test()
	public void ITS_09_01() throws IOException{
		ContactScreen.contact(driver, "", "testforname@gmail.com", "testforname", ContactScreen.emptyNameMsg);
	}	
	
	@Test()
	public void ITS_09_02() throws IOException{
		ContactScreen.contact(driver, "         ", "testforname@gmail.com", "testforname", ContactScreen.emptyNameMsg);
	}	

	@Test()
	public void ITS_09_03() throws IOException{
		ContactScreen.contact(driver, "test for name", "testforname@gmail.com", "testforname", "");
	}
	
	@Test()
	public void ITS_09_04() throws IOException{
		ContactScreen.contact(driver, "test for email", "", "test for email", ContactScreen.emptyEmailMsg);
	}
	
	@Test()
	public void ITS_09_05() throws IOException{
		ContactScreen.contact(driver, "test for email", "          ", "test for email", ContactScreen.emptyEmailMsg);
	}
	
	@Test()
	public void ITS_09_06() throws IOException{
		ContactScreen.contact(driver, "test for email", " testforemail@gmail.com ", "test for email", "");
	}

	@Test()
	public void ITS_09_07() throws IOException{
		ContactScreen.contact(driver, "test for email", "test for email@gmail.com", "test for email", ContactScreen.invalidEmailMsg);
	}
	
	@Test()
	public void ITS_09_08() throws IOException{
		ContactScreen.contact(driver, "test for email", "testforemailgmail.com", "test for email", ContactScreen.invalidEmailMsg);
	}
	
	@Test()
	public void ITS_09_09() throws IOException{
		ContactScreen.contact(driver, "test for email", "testforemail@gmailcom", "test for email", ContactScreen.invalidEmailMsg);
	}
	
	@Test()
	public void ITS_09_10() throws IOException{
		ContactScreen.contact(driver, "test for email", "testforemail@com", "test for email", ContactScreen.invalidEmailMsg);
	}
	
	@Test()
	public void ITS_09_11() throws IOException{
		ContactScreen.contact(driver, "test for content", "testforcontent@gmail.com", "", ContactScreen.emptyContentMsg);
	}
	
	@Test()
	public void ITS_09_12() throws IOException{
		ContactScreen.contact(driver, "test for content", "testforcontent@gmail.com", "          ", ContactScreen.emptyContentMsg);
	}
	
	@Test()
	public void ITS_09_13() throws IOException{
		ContactScreen.contact(driver, "test for content", "testforcontent@gmail.com", "test for content", "");
	}
	
	@Test()
	public void ITS_09_14() throws IOException{
		ContactScreen.contact(driver, "test for content", "testforcontent@gmail.com", "test\nfor\ncontent", "");
	}
}
