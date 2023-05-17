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

public class OrderWithoutLogin extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = HomeScreen.openScreenWithoutLogin(browser);
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
	public void ITS_08_09() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, "", Constant.BASE_PHONE, Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.emptyNameMsg);
	}
	
	@Test()
	public void ITS_08_10() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, "          ", Constant.BASE_PHONE, Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.emptyNameMsg);
	}
	
	@Test()
	public void ITS_08_11() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_12() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.emptyPhoneMsg);
	}
	
	@Test()
	public void ITS_08_13() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "         ", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.emptyPhoneMsg);
	}
	
	@Test()
	public void ITS_08_14() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, " " + Constant.BASE_PHONE + " ", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_15() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_16() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "abcdefghij", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_08_17() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "~!@#$%^&*(", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_08_18() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "<p>test</p>", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_08_19() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "drop table admins;", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_08_20() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "alert(\"Hello! I am an alert box!\");", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_08_21() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "000000000", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_08_22() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "012345678", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_08_23() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "01234567890", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_24() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "   0123456789  ", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_25() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, "0123456789012345", Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.invalidPhoneMsg);
	}
	
	@Test()
	public void ITS_08_26() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, "", Constant.BASE_NOTE, PaymentInfoScreen.emptyAddressMsg);
	}
	
	@Test()
	public void ITS_08_27() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, "         ", Constant.BASE_NOTE, PaymentInfoScreen.emptyAddressMsg);
	}
	
	@Test()
	public void ITS_08_28() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_29() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, "Nhổn\nHà Nội", Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_30() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_31() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "          ", PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_32() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Constant.BASE_NOTE, PaymentInfoScreen.successMsg);
	}
	
	@Test()
	public void ITS_08_33() throws IOException {
		PaymentInfoScreen.orderWithoutLogin(driver, Constant.BASE_USERNAME, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "Ghi chú\nnhiều dòng", PaymentInfoScreen.successMsg);
	}
}
