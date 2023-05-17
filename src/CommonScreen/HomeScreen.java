package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class HomeScreen {
	public static String loginLinkXpath 			= "//*[@class='link-account']";
	public static String registerLinkXpath 			= "//*[@class='em-register-link']";
	public static String homeLinkXpath 				= "(//*[text()='Trang chủ'])[2]";
	public static String contactLinkXpath 			= "//*[text()=' Liên hệ ']";
	
	public static String usernameLinkXpath 			= "//a[contains(text(),'" + Constant.BASE_USERNAME + "')]";
	public static String logoutLinkXpath 			= "//a[contains(text(),'Đăng xuất')]";
	public static String changePwdLinkXpath 		= "//a[contains(text(),'Đổi mật khẩu')]";
	
	public static String searchIconXpath 			= "//a[@class='em-search-icon']";
	public static String searchTxtID				= "search";
	public static String searchBtnXpath 			= "(//button[@title='Search'])[2]";
	public static String titleSearchLbXpath 		= "//p[contains(text(),'Kết quả tìm kiếm cho')]";
	public static String searchResultDivXpath 		= "//div[@class='product-item']";
	
	public static String noResultMsg 				= "              Rất tiếc! Không có sản phẩm nào được tìm thấy!         ";
	public static String noResultMsgXpath 			= "//p[text()='" + noResultMsg + "']";
	
	public static String productLinkXpath 			= "(//div[@class='product-shop-top'])[1]";
	public static String productLinkXpath2 			= "(//div[@class='product-shop-top'])[2]";
	
	public static String msgXpath 					= "//div[@class='swal-text']";
	public static String addToCartSuccessMsg 		= "Sản phẩm của bạn đã được thêm vào giỏ hàng";
	public static String continueShoppingBtnXpath 	= "//button[@class='swal-button swal-button--cancel']";
	public static String totalQtyLbXpath 			= "(//span[@class='em-topcart-qty'])[2]";
	public static String orderNowBtnXpath 			= "//button[contains(text(),'Gửi đơn hàng ngay!')]";

	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, LoginScreen.loginBtnXpath, Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
		}
		return driver;
	}
	
	public static WebDriver openScreenWithoutLogin(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
		}
		return driver;
	}

	public static void search(WebDriver driver, String keyword, boolean isSuccess) {
		Utilities.inputValueAndValidate(driver, By.id(searchTxtID), keyword, keyword);
		Utilities.clickObscuredElement(driver, searchBtnXpath, titleSearchLbXpath, Constant.WAIT_ELEMENT_EXIST);
		int countSearchResult =  Utilities.getXpathCount(driver, searchResultDivXpath);
		if (isSuccess) {
			if (countSearchResult == 0) {
				Utilities.assertFail(driver, "Search result is incorrect");
			}
		} 
		else {
			Utilities.assertString("0", Integer.toString(countSearchResult));
		}
	}
	
	public static void logout(WebDriver driver) {
		Utilities.clickObscuredElement(driver, HomeScreen.usernameLinkXpath, HomeScreen.logoutLinkXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.logoutLinkXpath, HomeScreen.loginLinkXpath, Constant.WAIT_ELEMENT_EXIST);
	}
}
