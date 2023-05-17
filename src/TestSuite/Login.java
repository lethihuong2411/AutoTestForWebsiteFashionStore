package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;
import CommonScreen.LoginScreen;

public class Login extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = LoginScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
		if (!Utilities.checkElementVisible(driver, By.xpath(HomeScreen.loginLinkXpath))) {
			Utilities.clickObscuredElement(driver, HomeScreen.usernameLinkXpath, HomeScreen.logoutLinkXpath, Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, HomeScreen.logoutLinkXpath, HomeScreen.loginLinkXpath, Constant.WAIT_ELEMENT_EXIST);
		}
		driver.get(Constant.URL_LOGIN);
	}
		
	@Test()
	public void ITS_02_01() throws IOException{
		LoginScreen.login(driver, "", Constant.BASE_PASSWORD, LoginScreen.emptyPhoneMsg);
	}	

	@Test()
	public void ITS_02_02() throws IOException{
		LoginScreen.login(driver, "          ", Constant.BASE_PASSWORD, LoginScreen.emptyPhoneMsg);
	}		
	
	@Test()
	public void ITS_02_03() throws IOException{
		LoginScreen.login(driver, " " + Constant.BASE_PHONE + " ", Constant.BASE_PASSWORD, "");
	}
	
	@Test()
	public void ITS_02_04() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
	}
	
	@Test()
	public void ITS_02_05() throws IOException{
		LoginScreen.login(driver, "abcd", Constant.BASE_PASSWORD,LoginScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_02_06() throws IOException{
		LoginScreen.login(driver, "@#$%", Constant.BASE_PASSWORD, LoginScreen.invalidPhoneMsg);
	}
		
	@Test()
	public void ITS_02_07() throws IOException{
		LoginScreen.login(driver, "<p>test</p>", Constant.BASE_PASSWORD, LoginScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_02_08() throws IOException{
		LoginScreen.login(driver, "drop table admins;", Constant.BASE_PASSWORD, LoginScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_02_09() throws IOException{
		LoginScreen.login(driver, "alert(\"Hello! I am an alert box!\");", Constant.BASE_PASSWORD, LoginScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_02_10() throws IOException{
		LoginScreen.login(driver, "0000000000", Constant.BASE_PASSWORD, LoginScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_02_11() throws IOException{
		LoginScreen.login(driver, "012345678", Constant.BASE_PASSWORD, LoginScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_02_12() throws IOException{
		LoginScreen.login(driver, "0123456789", Constant.BASE_PASSWORD, "");
	}
	
	@Test()
	public void ITS_02_13() throws IOException{
		LoginScreen.login(driver, "(+84)0335046969", Constant.BASE_PASSWORD, "");
	}
	
	@Test()
	public void ITS_02_14() throws IOException{
		LoginScreen.login(driver, "0123456789123456", Constant.BASE_PASSWORD, LoginScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_02_15() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, "", LoginScreen.emptyPasswordMsg);
	}
	
	@Test()
	public void ITS_02_16() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, "                ", LoginScreen.emptyPasswordMsg);
	}
	
	@Test()
	public void ITS_02_17() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, "1234567", LoginScreen.minPasswordMsg);
	}
	
	@Test()
	public void ITS_02_18() throws IOException{
		LoginScreen.login(driver, "0123456789", "12345678", LoginScreen.minPasswordMsg);
	}
	
	@Test()
	public void ITS_02_19() throws IOException{
		LoginScreen.login(driver, "0963852741", "1234567890123456", LoginScreen.minPasswordMsg);
	}
	
	@Test()
	public void ITS_02_20() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, "12345678901234567", LoginScreen.maxPasswordMsg);
	}
	
	@Test()
	public void ITS_02_21() throws IOException{
		LoginScreen.login(driver, "0963741852", Constant.BASE_PASSWORD, LoginScreen.incorrectLoginMsg);
	}
	
	@Test()
	public void ITS_02_22() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD + "1", LoginScreen.incorrectLoginMsg);
	}
	
	@Test()
	public void ITS_02_23() throws IOException{
		LoginScreen.login(driver, "0963741852", Constant.BASE_PASSWORD + "1", LoginScreen.incorrectLoginMsg);
	}
}
