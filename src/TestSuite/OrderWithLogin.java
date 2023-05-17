package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;
import CommonScreen.PaymentInfoScreen;

public class OrderWithLogin extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = HomeScreen.openScreen(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		PaymentInfoScreen.openScreen(driver);
		Utilities.testID = method.getName();
	}
	
	@AfterMethod()
	public void tearDownMethod(Method method) throws Exception {
		Utilities.captureScreen(driver, method.getName());
		Utilities.clickObscuredElement(driver, HomeScreen.homeLinkXpath, HomeScreen.productLinkXpath, Constant.WAIT_ELEMENT_EXIST);
	}

	@Test()
	public void ITS_08_01() throws IOException {
		PaymentInfoScreen.orderWithLogin(driver, "", Constant.BASE_NOTE, PaymentInfoScreen.emptyAddressMsg);
	}
	
	@Test()
	public void ITS_08_02() throws IOException {
		PaymentInfoScreen.orderWithLogin(driver, "         ", Constant.BASE_NOTE, PaymentInfoScreen.emptyAddressMsg);
	}
	
	@Test()
	public void ITS_08_03() throws IOException {
		PaymentInfoScreen.orderWithLogin(driver, Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_04() throws IOException {
		PaymentInfoScreen.orderWithLogin(driver, "Nhổn\nHà Nội", Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_05() throws IOException {
		PaymentInfoScreen.orderWithLogin(driver, Constant.BASE_ADDRESS, "", PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_06() throws IOException {
		PaymentInfoScreen.orderWithLogin(driver, Constant.BASE_ADDRESS, "          ", PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_07() throws IOException {
		PaymentInfoScreen.orderWithLogin(driver, Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_08() throws IOException {
		PaymentInfoScreen.orderWithLogin(driver, Constant.BASE_ADDRESS, "Ghi chú\nnhiều dòng", PaymentInfoScreen.successMsg);
	}
}
