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
import CommonScreen.ProductDetailScreen;

public class ViewProductDetail extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = HomeScreen.openScreenWithoutLogin(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
	}

	@Test()
	public void ITS_06_01() throws IOException {
		Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.productLinkXpath), By.id(ProductDetailScreen.addToCartBtnID), Constant.WAIT_ELEMENT_EXIST);
	}
}
