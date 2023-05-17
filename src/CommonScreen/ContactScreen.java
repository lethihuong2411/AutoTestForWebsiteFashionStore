package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class ContactScreen {
	// Text field
	public static String nameTxtID				= "name";
	public static String emailTxtID 			= "email";
	public static String contentTxtID 			= "content";
	
	// Button
	public static String contactBtnXpath		= "//button[@class='button btn-contact']";
	
	// Message
	public static String errMsgXpath 			= "//div[@class='error-message-contact']//ul//li";
	public static String successMsgXpath 		= "//div[@class='alert success-message-contact']//ul//li";
	
	// List of messages
	public static String emptyNameMsg			= "Bạn cần nhập tên";
	public static String emptyEmailMsg			= "Bạn cần nhập email";
	public static String emptyContentMsg 		= "Bạn cần nhập nội dung";
	public static String invalidEmailMsg		= "Email không đúng định dạng";
	public static String contactSuccessMsg 		= "Cám ơn bạn đã liên hệ với chúng tôi. Chúc bạn sức khỏe và thành công!";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.contactLinkXpath, ContactScreen.contactBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void contact(WebDriver driver, String name, String email, String content, String expectErrMsg) {
		Utilities.inputValueAndValidate(driver, By.id(nameTxtID), name, name);
		Utilities.inputValueAndValidate(driver, By.id(emailTxtID), email, email);
		Utilities.inputValueAndValidate(driver, By.id(contentTxtID), content, content);
		if (expectErrMsg == "") {
			Utilities.clickObscuredElement(driver, contactBtnXpath, successMsgXpath, Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(successMsgXpath), contactSuccessMsg);
		}
		else {
			Utilities.clickObscuredElement(driver, contactBtnXpath, errMsgXpath, Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(errMsgXpath), expectErrMsg);
		}
	}
	

}
