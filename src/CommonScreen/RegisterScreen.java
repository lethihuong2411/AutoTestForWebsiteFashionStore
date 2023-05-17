package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class RegisterScreen {
	// Text field
	public static String phoneTxtID				= "phone_number";
	
	// Button
	public static String registerBtnXpath		= "//span[contains(text(),'ĐĂNG KÝ')]";
	
	// Error message 
	public static String errorMsgXpath 			= "//div[@class='error-mesage']//ul//li";
	public static String unsuccessMsgXpath 		= "//div[@class='unsuccess-mesage']//ul//li";
	
	// List of messages
	public static String emptyPhoneMsg			= "Lỗi: Vui lòng nhập các trường bắt buộc (*).";
	public static String registeredPhoneMsg 	= "Số điện thoại này đã đăng kí.";
	public static String invalidPhoneMsg		= "Số điện thoại không hợp lệ, vui lòng thử lại.";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.registerLinkXpath, registerBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void register(WebDriver driver, String phone, String expectErrMsg) {
		Utilities.waitForElementVisibility(driver, By.id(phoneTxtID));
		Utilities.inputValueAndValidate(driver, By.id(phoneTxtID), phone, phone);	
		if (expectErrMsg == "") {
			Utilities.clickObscuredElement(driver, By.xpath(registerBtnXpath), By.xpath(AccountInfoScreen.titleScreenXpath), Constant.WAIT_ELEMENT_EXIST);
		}
		else if (expectErrMsg == registeredPhoneMsg) {
			Utilities.clickObscuredElement(driver, By.xpath(registerBtnXpath), By.xpath(unsuccessMsgXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(unsuccessMsgXpath), expectErrMsg);
		}
		else {
			Utilities.clickObscuredElement(driver, By.xpath(registerBtnXpath), By.xpath(errorMsgXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(errorMsgXpath), expectErrMsg);
		}
	}	
}
