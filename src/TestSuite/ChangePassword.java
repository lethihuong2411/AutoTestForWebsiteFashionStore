package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.ChangePasswordScreen;
import CommonScreen.HomeScreen;


public class ChangePassword extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = HomeScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
		Utilities.clickObscuredElement(driver, HomeScreen.usernameLinkXpath, HomeScreen.changePwdLinkXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.changePwdLinkXpath, ChangePasswordScreen.updateBtnXpath, Constant.WAIT_ELEMENT_EXIST);
	}
		
	@Test()
	public void ITS_04_01() throws IOException{
		ChangePasswordScreen.changePassword(driver, "", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.emptyOldPasswordMsg);
	}	
	
	@Test()
	public void ITS_04_02() throws IOException{
		ChangePasswordScreen.changePassword(driver, "        ", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.emptyOldPasswordMsg);
	}	
	
	@Test()
	public void ITS_04_03() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.PWD_7_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.minPasswordMsg);
	}
	
	@Test()
	public void ITS_04_04() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_8_CHARS, Constant.PWD_8_CHARS, ChangePasswordScreen.changePasswordSuccessMsg);
		ChangePasswordScreen.changePassword(driver, Constant.PWD_8_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}
	
	@Test()
	public void ITS_04_05() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_16_CHARS, Constant.PWD_16_CHARS, ChangePasswordScreen.changePasswordSuccessMsg);
		ChangePasswordScreen.changePassword(driver, Constant.PWD_16_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}
	
	@Test()
	public void ITS_04_06() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.PWD_17_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.maxPasswordMsg);
	}
	
	@Test()
	public void ITS_04_07() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, "", Constant.BASE_PASSWORD, ChangePasswordScreen.emptyNewPasswordMsg);
	}

	@Test()
	public void ITS_04_08() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, "        ", Constant.BASE_PASSWORD, ChangePasswordScreen.emptyNewPasswordMsg);
	}
	
	@Test()
	public void ITS_04_09() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_7_CHARS, Constant.PWD_7_CHARS, ChangePasswordScreen.minPasswordMsg);
	}
	
	@Test()
	public void ITS_04_10() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_8_CHARS, Constant.PWD_8_CHARS, ChangePasswordScreen.changePasswordSuccessMsg);
		ChangePasswordScreen.changePassword(driver, Constant.PWD_8_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}
	
	@Test()
	public void ITS_04_11() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_16_CHARS, Constant.PWD_16_CHARS, ChangePasswordScreen.changePasswordSuccessMsg);
		ChangePasswordScreen.changePassword(driver, Constant.PWD_16_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}
	
	@Test()
	public void ITS_04_12() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_17_CHARS, Constant.PWD_17_CHARS, ChangePasswordScreen.maxPasswordMsg);
	}
	
	@Test()
	public void ITS_04_13() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_8_CHARS, "", ChangePasswordScreen.emptyNewPasswordConfirmMsg);
	}
	
	@Test()
	public void ITS_04_14() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_8_CHARS, "        ", ChangePasswordScreen.emptyNewPasswordConfirmMsg);
	}
	
	@Test()
	public void ITS_04_15() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_7_CHARS, Constant.PWD_7_CHARS, ChangePasswordScreen.minPasswordMsg);
	}
	
	@Test()
	public void ITS_04_16() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_8_CHARS, Constant.PWD_8_CHARS, ChangePasswordScreen.changePasswordSuccessMsg);
		ChangePasswordScreen.changePassword(driver, Constant.PWD_8_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}
	
	@Test()
	public void ITS_04_17() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_16_CHARS, Constant.PWD_16_CHARS, ChangePasswordScreen.changePasswordSuccessMsg);
		ChangePasswordScreen.changePassword(driver, Constant.PWD_16_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}
	
	@Test()
	public void ITS_04_18() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_17_CHARS, Constant.PWD_17_CHARS, ChangePasswordScreen.maxPasswordMsg);
	}
	
	@Test()
	public void ITS_04_19() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.sameOldPasswordMsg);
	}
	
	@Test()
	public void ITS_04_20() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.PWD_8_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.incorrectPasswordMsg);
	}
	
	@Test()
	public void ITS_04_21() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.PWD_8_CHARS, Constant.PWD_16_CHARS, ChangePasswordScreen.unmatchingPasswordMsg);
	}
}
