package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class LoginScreen {
	// Text field
	public static String phoneTxtID				= "phone";
	public static String passwordTxtID			= "password";
	
	// Button
	public static String loginBtnXpath			= "//button[@class='button btn-login']";
	
	// Error message
	public static String errorMsgXpath 			= "//div[@class='alert alert-warning login-faile-msg']//ul//li";
	public static String errorMsgXpath2			= "//div[@class='alert alert-warning user-incorrect-msg']//ul//li";
	
	// List of messages
	public static String emptyPhoneMsg			= "Bạn chưa nhập tài khoản";
	public static String emptyPasswordMsg		= "Bạn chưa nhập mật khẩu";
	public static String invalidPhoneMsg		= "Số điện thoại không hợp lệ, vui lòng thử lại.";
	public static String minPasswordMsg			= "Mật khẩu tối thiểu 8 kí tự";
	public static String maxPasswordMsg			= "Mật khẩu tối đa 16 kí tự";
	public static String incorrectLoginMsg		= "Sai tài khoản hoặc mật khẩu!";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, loginBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void login(WebDriver driver, String phone, String password, String expectErrMsg) {
		Utilities.waitForElementVisibility(driver, By.id(phoneTxtID));
		Utilities.inputValueAndValidate(driver, By.id(phoneTxtID), phone, phone);
		Utilities.inputValueAndValidate(driver, By.id(passwordTxtID), password, password);
		if (expectErrMsg == "") {
			Utilities.clickObscuredElement(driver, By.xpath(loginBtnXpath), By.xpath(HomeScreen.usernameLinkXpath), Constant.WAIT_ELEMENT_EXIST);
		}
		else if (expectErrMsg == emptyPhoneMsg || expectErrMsg == emptyPasswordMsg) {
			Utilities.clickObscuredElement(driver, By.xpath(loginBtnXpath), By.xpath(errorMsgXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(errorMsgXpath), expectErrMsg);
		}
		else {
			Utilities.clickObscuredElement(driver, By.xpath(loginBtnXpath), By.xpath(errorMsgXpath2), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(errorMsgXpath2), expectErrMsg);
		}
	}	
}
