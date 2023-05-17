package Common;

public final class Constant {
	// Define general information to access test application
	public static String BASE_URL		 		= "http://localhost:8000/";
	public static String URL_REGISTER 			= BASE_URL + "register";
	public static String URL_LOGIN				= BASE_URL + "login";
	public static String URL_CHANGE_PWD			= BASE_URL + "change/pasword";

	// User name and password to access website
	public static String BASE_PHONE 			= "0987654321";
	public static String BASE_PASSWORD			= "1234567890";
	public static String BASE_USERNAME 			= "Lê Thị Hương";
	public static String BASE_ADDRESS 			= "Hà Nội";
	public static String BASE_NOTE	 			= "Ghi chú";
	
	public static String PWD_7_CHARS 			= "1234567";
	public static String PWD_8_CHARS 			= "12345678";
	public static String PWD_16_CHARS 			= "1234567890123456";
	public static String PWD_17_CHARS 			= "12345678901234567";

	// Define timeout
	public static final double WAIT_INTERVAL = 1.5; 
	public static final int WAIT_WINDOW = 10;
	public static final double WAIT_CLOSE_WINDOW = 2.5;
	public static final double WAIT_CLOSE_WINDOW_MAX = 3.5;
	public static final int WAIT_ELEMENT_EXIST = 15;
	public static final int WAIT_ELEMENT_NOT_EXIST = 2;
	public static final int WAIT_NETWORK = 10;
	public static final double WAIT_REFRESH_SCREEN = 2.0;
	public static final int WAIT_CLICKABLE = 60;
	public static final double WAIT_LOAD_SCREEN = 2.5;

	// Define threshold
	public static final double SIMILITY_THRESHOLD = 0.99;

	// Define browser
	public static final String IE_BROWSER = "IE";
	public static final String EDGE_BROWSER = "Edge";
	public static final String CHROME_BROWSER = "Chrome";
	public static final String FIREFOX_BROWSER = "FireFox";
	public static final String MSEDGE_BROWSER = "MSEdge";

	// Path to storage
	public static String IMAGE_PATH = "./images/";
	public static String DATA_PATH = "./data/";

}
