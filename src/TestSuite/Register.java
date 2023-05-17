package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.RegisterScreen;


public class Register extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = RegisterScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
		driver.get(Constant.URL_REGISTER);
	}
		
	@Test()
	public void ITS_01_01() throws IOException{
		RegisterScreen.register(driver, "", RegisterScreen.emptyPhoneMsg);
	}
	
	@Test()
	public void ITS_01_02() throws IOException{
		RegisterScreen.register(driver, "          ", RegisterScreen.emptyPhoneMsg);
	}
	
	@Test()
	public void ITS_01_03() throws IOException{
		RegisterScreen.register(driver, "0123 456 789", "");
	}

	@Test()
	public void ITS_01_04() throws IOException{
		RegisterScreen.register(driver, "0987654321", RegisterScreen.registeredPhoneMsg);
	}
	
	@Test()
	public void ITS_01_05() throws IOException{
		RegisterScreen.register(driver, "abcd", RegisterScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_01_06() throws IOException{
		RegisterScreen.register(driver, "@#$%", RegisterScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_01_07() throws IOException{
		RegisterScreen.register(driver, "<p>test</p>", RegisterScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_01_08() throws IOException{
		RegisterScreen.register(driver, "drop table admins;", RegisterScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_01_09() throws IOException{
		RegisterScreen.register(driver, "alert(\"Hello! I am an alert box!\");", RegisterScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_01_10() throws IOException{
		RegisterScreen.register(driver, "0000000000", RegisterScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_01_11() throws IOException{
		RegisterScreen.register(driver, "012345678", RegisterScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_01_12() throws IOException{
		RegisterScreen.register(driver, "0123456789", "");
	}
	
	@Test()
	public void ITS_01_13() throws IOException{
		RegisterScreen.register(driver, "(+84)0335046868", "");
	}
	
	@Test()
	public void ITS_01_14() throws IOException{
		RegisterScreen.register(driver, "0123456789123456", RegisterScreen.invalidPhoneMsg);
	}
}
