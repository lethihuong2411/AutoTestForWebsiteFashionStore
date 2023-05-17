package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class ChangePasswordScreen {
	// Text field
	public static String oldPasswordTxtID 				= "getOldPass";
	public static String newPasswordTxtID 				= "getNewPass";
	public static String newPasswordConfirmTxtID 		= "getReNewPass";
	
	// Button
	public static String updateBtnXpath					= "//button[@class='btn btn-info btn-save']";
	
	// Error message xpath
	public static String errorMsgXpath 					= "//div[@class='alert alert-danger error-mesage']//ul//li";
	public static String successMsgXpath 				= "//div[@class='alert alert-success success-mesage']//ul//li";
	public static String unsuccessMsgXpath 				= "//div[@class='alert alert-warning unsuccess-mesage']//ul//li";
	
	// List of message
	public static String emptyOldPasswordMsg 			= "Bạn chưa nhập mật khẩu cũ";
	public static String emptyNewPasswordMsg 			= "Bạn chưa nhập mật khẩu mới";
	public static String emptyNewPasswordConfirmMsg 	= "Bạn cần nhập lại mật khẩu mới";
	public static String minPasswordMsg 				= "Mật khẩu tối thiểu 8 kí tự";
	public static String maxPasswordMsg 				= "Mật khẩu tối đa 16 kí tự";
	public static String sameOldPasswordMsg 			= "Mật khẩu mới giống mật khẩu hiện tại !!";
	public static String incorrectPasswordMsg 			= "Mật khẩu hiện tại không đúng";
	public static String unmatchingPasswordMsg 			= "Mật khẩu mới không khớp !!";
	public static String changePasswordSuccessMsg 		= "Đổi mật khẩu thành công";

	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, HomeScreen.loginLinkXpath, Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
			Utilities.clickObscuredElement(driver, HomeScreen.usernameLinkXpath, HomeScreen.changePwdLinkXpath, Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, HomeScreen.changePwdLinkXpath, ChangePasswordScreen.updateBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void changePassword(WebDriver driver, String oldPassword, String newPassword, String newPasswordConfirm, String expectErrMsg) {
		Utilities.inputValueAndValidate(driver, By.id(oldPasswordTxtID), oldPassword, oldPassword);
		Utilities.inputValueAndValidate(driver, By.id(newPasswordTxtID), newPassword, newPassword);
		Utilities.inputValueAndValidate(driver, By.id(newPasswordConfirmTxtID), newPasswordConfirm, newPasswordConfirm);
		
		if (expectErrMsg.equals(changePasswordSuccessMsg)) {
			Utilities.clickObscuredElement(driver, By.xpath(updateBtnXpath), By.xpath(successMsgXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(successMsgXpath), expectErrMsg);
		}
		else if (expectErrMsg.equals(sameOldPasswordMsg) || expectErrMsg.equals(incorrectPasswordMsg) || expectErrMsg.equals(unmatchingPasswordMsg)) {
			Utilities.clickObscuredElement(driver, By.xpath(updateBtnXpath), By.xpath(unsuccessMsgXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(unsuccessMsgXpath), expectErrMsg);
		}
		else {
			Utilities.clickObscuredElement(driver, By.xpath(updateBtnXpath), By.xpath(errorMsgXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(errorMsgXpath), expectErrMsg);
		}
	}
}
