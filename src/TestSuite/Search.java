package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;

public class Search extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = HomeScreen.openScreenWithoutLogin(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
		Utilities.clickObscuredElement(driver, HomeScreen.searchIconXpath, HomeScreen.searchBtnXpath, Constant.WAIT_ELEMENT_EXIST);
	}

	@Test()
	public void ITS_05_01() throws IOException {
		HomeScreen.search(driver, "", true);
	}

	@Test()
	public void ITS_05_02() throws IOException {
		HomeScreen.search(driver, "          ", true);
	}

	@Test()
	public void ITS_05_03() throws IOException {
		HomeScreen.search(driver, "ÁO KHOÁC PHAO CỔ MŨ VIỀN LÔNG", true);
	}

	@Test()
	public void ITS_05_04() throws IOException {
		HomeScreen.search(driver, "ÁO KHOÁC", true);
	}

	@Test()
	public void ITS_05_05() throws IOException {
		HomeScreen.search(driver, "test demo", false);
	}
	
	@Test()
	public void ITS_05_06() throws IOException {
		HomeScreen.search(driver, "áo khoác", true);
	}
}
