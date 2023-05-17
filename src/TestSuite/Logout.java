package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;

public class Logout extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = HomeScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
	}
		
	@Test()
	public void ITS_03_01() throws IOException{
		HomeScreen.logout(driver);
	}	
}
