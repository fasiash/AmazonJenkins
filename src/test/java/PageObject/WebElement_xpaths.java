package PageObject;


import org.openqa.selenium.By;

public class WebElement_xpaths {
	
	String url = "https://www.amazon.in";
	By signin_page 			= By.xpath("//span[. = 'Hello, sign in']");
	By signin_btn			= By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
	By Email_field 			= By.xpath("//input[@id='ap_email']");
	By Continue_btn			= By.xpath("//input[@id='continue']");
	By Password_field		= By.xpath("//input[@id='ap_password']");
	By Email_field1         = By.xpath("//a[@id=\"ap_change_login_claim\"]"); 
	By Login_btn 			= By.xpath("//input[@id='signInSubmit']");
	By Search_bar			= By.xpath("//input[@id='twotabsearchtextbox']");
	By search_btn			= By.xpath("//input[@id='nav-search-submit-button']");
	By watch				= By.xpath("//img[@alt='Sponsored Ad - Fire-Boltt Quantum Luxury Stainless Steel Design 1.28\" Bluetooth "
			+ "Calling Smartwatch with High Resolution of...']");
	By Quantity				= By.xpath("//select[@id='quantity']");
	By Add_to_cart_btn		= By.xpath("(//input[@id='add-to-cart-button'])[2]");
	By Add_to_cart_btn1		= By.xpath("//input[@id='add-to-cart-button']");
	//By Add_to_cart_btn		= By.id("add-to-cart-button");
	By Added_to_cart_text	= By.xpath("//div[@id = 'attachDisplayAddBaseAlert']/div/h4[. = 'Added to Cart']");
	By Cross_button			= By.id("attach-close_sideSheet-link");
	By mobiles_tab			= By.xpath("//a[.='Mobiles']");
	By mobile_accessories	= By.xpath("//span[@class='nav-a-content' and normalize-space()='Mobiles & Accessories']");
	By Apple_tab			= By.xpath("(//a[.='Apple'])[1]");
	By Apple_mobile			= By.xpath("//a/span[.='Apple iPhone 14 (128 GB) - Blue']");
	By Cart					= By.xpath("//span[normalize-space()='Cart']");
	By Electronic_tab 		= By.xpath("//a[.=' Electronics ']");
	By Audio_btn			= By.xpath("//span[@class='nav-a-content' and normalize-space()='Audio']");
	By Boat_brand			= By.xpath("(//li/a[.='Boat'])[3]");
	By Boat_Speaker			= By.xpath("//span[.='boAt Stone 352 Bluetooth Speaker with 10W RMS Stereo Sound, IPX7 Water Resistance, TWS Feature,"
			+ " Up to 12H Total Playtime, Multi-Compatibility Modes and Type-C Charging(Raging Black)']");
	By Delete_Apple_mobile  = By.xpath("//input[@aria-label=\"Delete Apple iPhone 14 (128 GB) - Blue\"]");
	By Delete_Boat_Speaker  = By.xpath("(//span/input[@value='Delete' and @type='submit'])[1]");
	By Checkout_Product     = By.xpath("//input[@name=\"proceedToRetailCheckout\"]");
	By Checkout_text        = By.xpath("//div[normalize-space()='Checkout']");
	By Logo                 = By.xpath("(//div[@class=\"a-row\"])[1]");
	By Return_to_cart       = By.xpath("(//a[@id='a-autoid-1-announce'])[1]");  
	By Delete_watch         = By.xpath("(//input[@type='submit'])[3]");
	By Empty_cart           = By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']");
}
