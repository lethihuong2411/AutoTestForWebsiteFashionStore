package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;
import CommonScreen.ProductDetailScreen;

public class AddToCart extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = HomeScreen.openScreenWithoutLogin(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
	}
	
	@AfterMethod()
	public void tearDownMethod(Method method) throws Exception {
		Utilities.captureScreen(driver, method.getName());
		Utilities.clickObscuredElementToNotVisible(driver, By.xpath(HomeScreen.continueShoppingBtnXpath), By.xpath(HomeScreen.continueShoppingBtnXpath), Constant.WAIT_ELEMENT_NOT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.homeLinkXpath, HomeScreen.productLinkXpath, Constant.WAIT_ELEMENT_EXIST);
	}

	@Test()
	public void ITS_07_01() throws IOException {
		Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.productLinkXpath), By.id(ProductDetailScreen.addToCartBtnID), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, By.id(ProductDetailScreen.addToCartBtnID), By.xpath(HomeScreen.msgXpath), Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.msgXpath), HomeScreen.addToCartSuccessMsg);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.totalQtyLbXpath), "1");
	}

	@Test()
	public void ITS_07_02() throws IOException {
		Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.productLinkXpath2), By.id(ProductDetailScreen.addToCartBtnID), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, By.id(ProductDetailScreen.addToCartBtnID), By.xpath(HomeScreen.msgXpath), Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.msgXpath), HomeScreen.addToCartSuccessMsg);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.totalQtyLbXpath), "2");
	}

	@Test()
	public void ITS_07_03() throws IOException {
		Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.productLinkXpath2), By.id(ProductDetailScreen.addToCartBtnID), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, By.id(ProductDetailScreen.addToCartBtnID), By.xpath(HomeScreen.msgXpath), Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.msgXpath), HomeScreen.addToCartSuccessMsg);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.totalQtyLbXpath), "3");
	}
}
