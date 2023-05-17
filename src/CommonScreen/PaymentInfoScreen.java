package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class PaymentInfoScreen {
	public static String nameTxtID = "getName";
	public static String phoneTxtID = "getPhone";
	public static String addressTxtID = "getAddress";
	public static String noteTxtID = "getNote";

	public static String orderBtnXpath = "//*[@id='load']";

	public static String msgXpath = "//*[@class='alert']//ul";

	public static String successMsg = "Cám ơn bạn. Đơn hàng của bạn đã được tiếp nhận.";
	public static String emptyNameMsg = "Tên khách hàng không được để trống";
	public static String emptyPhoneMsg = "Số điện thoại không được để trống";
	public static String invalidPhoneMsg = "Số điện thoại không hợp lệ";
	public static String emptyAddressMsg = "Địa chỉ nhận hàng không được để trống";

	public static void openScreen(WebDriver driver) {
		Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.productLinkXpath),
				By.id(ProductDetailScreen.addToCartBtnID), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, By.id(ProductDetailScreen.addToCartBtnID), By.xpath(HomeScreen.msgXpath),
				Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.orderNowBtnXpath, CartScreen.checkoutBtnXpath,
				Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, CartScreen.checkoutBtnXpath,
				PaymentInfoScreen.orderBtnXpath, Constant.WAIT_ELEMENT_EXIST);
	}

	public static void orderWithoutLogin(WebDriver driver, String name, String phone, String address, String note,
			String expectedMsg) {
		Utilities.inputValueAndValidate(driver, By.id(nameTxtID), name, name);
		Utilities.inputValueAndValidate(driver, By.id(phoneTxtID), phone, phone);
		Utilities.inputValueAndValidate(driver, By.id(addressTxtID), address, address);
		Utilities.inputValueAndValidate(driver, By.id(noteTxtID), note, note);
		Utilities.clickObscuredElement(driver, orderBtnXpath, msgXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValueVisible(driver, By.xpath(msgXpath), expectedMsg);
	}
	
	public static void orderWithLogin(WebDriver driver, String address, String note,
			String expectedMsg) {
		Utilities.inputValueAndValidate(driver, By.id(addressTxtID), address, address);
		Utilities.inputValueAndValidate(driver, By.id(noteTxtID), note, note);
		Utilities.clickObscuredElement(driver, orderBtnXpath, msgXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValueVisible(driver, By.xpath(msgXpath), expectedMsg);
	}
}
